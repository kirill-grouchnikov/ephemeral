## Ephemeral theming - component states

What is a component state? Let's take a look at buttons - the most basic building blocks on any UI toolkit. Buttons usually have icons and texts so that the users know what will happen when they click them. In addition, modern UI toolkits provide rich texturing capabilities that allow skinning different parts of the button visuals - such as background, border and focus ring. These visuals usually depend on the current state of the button.

If a button does not respond to UI events (such as mouse click, for instance), it is said to be disabled - and usually has a lighter or partially translucent appearance to match its disabled state. A toggle button can be in a selected state, conveying that certain application parameter is toggled on. A selected button is usually painted with different hue to facilitate quick scanning of the application state. There are more button states - rollover when the mouse is moved over it, pressed when the user pressed but has not yet released the mouse and default button which is invoked when the user presses the Enter key. The following screenshot shows how the same button can look like in different states:

<img src="https://raw.githubusercontent.com/kirill-grouchnikov/ephemeral/breeze/docs/images/theming/states/control-states-extended.png"
width="275" height="279"/>

Different controls have different states. For example, a progress bar can be determinate or indeterminate - depending on whether the application code can reliably assess the overall length of the work to be performed. A text component can be editable or uneditable. Input controls can be marked as required - to prevent the user from leaving the screen until he makes a selection on that control.

Ephemeral has a number of predefined component states to cover most action-based controls such as buttons, check boxes and menu items. In addition, custom component states can be defined to create finer grained mapping between arbitrary states of controls and specific color scheme bundles in custom skins.

Each component state is defined by two arrays of component state facets. The first array specifies the facets that are on, and the second array specifies the facets that are off. For example, when a selected toggle button is pressed, it transitions to `PressedSelected` state. This state has `ComponentStateFacet.Enable`, `ComponentStateFacet.Selection` and `ComponentStateFacet.Press` as its `on` facets. If a selected toggle button is disabled, it has `ComponentStateFacet.Selection` in its `on` facets and `ComponentStateFacet.Enable` in its `off` facets.

Ephemeral has a number of predefined core component state facets:

* `Enable`
* `Rollover`
* `Selection`
* `Press`
* `Determinate`
* `Indeterminate`
* `Mix`

The `Enable` facet is universal - it is relevant for all components. Some other facets apply to a generally broader range of components. For example, the `Rollover` facet applies to all components that can show rollover effects - including buttons, menu items, comboboxes, sliders, scrollbars and many more. Other facets apply to a more narrow range of components. For example, `Determinate` is only relevant for progress bars.

Ephemeral does not aim to cover all possible combinations of `on` and `off` facets. In addition to making the implementation too unwieldy, it is simply not feasible since application code can define its own facets. Instead, Ephemeral provides ways to fine-tune the mapping between the component states and the color schemes used to paint the components.

1. When the skin is queried for the color scheme that matches the specific component state - let's say `ComponentState.PressedSelected` - the skinning layer first looks for the exact state. If the exact match is found, it is used. If there is no exact match, the skinning layer will look at all color schemes registered for the specific color scheme association kind in the matching color scheme bundle. The decision is made based on how "close" the registered component state is to the component state of the currently painted component. For example, `ComponentState.PressedSelected` is a better match for `ComponentState.PressedUnselected` than `ComponentState.RolloverSelected` - since the `ComponentStateFacet.Press` has more weight than the `ComponentStateFacet.Rollover` in the decision process. The skinning layer will choose the "closest" registered component state that is sufficiently close. For example, `ComponentState.DisabledSelected` will never be chosen for `ComponentState.Selected` , even if there are no other registered component states. This way the application code can register a few color schemes in the specific bundle, and have all other states "fall back" to the smaller subset of states.
2. Custom application components may have facets that do not directly map to the core facets defined in the `ComponentStateFacet` class. In this case, the application code can create its own facet instances, and its own component states that use those facets in the on and off lists. Part of the custom code will be in the UI delegates that compute the current state of the custom component using the new facets. Other part of the custom code will be in the skin definition that maps the component states defined with the new facets to the specific color schemes.

Note that you do not have to create explicit dependency between custom component states used in the skin definition and custom component states used in the painting implementation. The recommended way to separate the skin definition from the model lookups in the painting is:

* The skin definition defines a sufficiently broad set of custom component states that use the new facets. Note that you do not have to create a custom state for every possible permutation of new facets (along with the relevant core facets). A well defined set of component states will provide a good fallback state for every relevant permutation of facets, keeping the skin definition small and manageable.
* The painting code that queries the component model will use accurate component states that account for all the relevant on and off facets - including the core facets defined in the `ComponentStateFacet` class. When this (perhaps elaborate) state is used to get the color scheme, the the procedure described above will match the this state to one of the "base" states defined in your skin, and use the matching color scheme.

Note that the matching algorithm only looks at the facets in the on and off lists, and ignores the component state name. This allows you to create a broad component state in your skin, and a number of narrow component states during the painting - and have the Ephemeral skinning layer find the best match.

When the matching algorithm cannot find a sufficiently close match, the skinning layer will fall back on one of the three base color schemes - active, enabled, disabled. States with `ComponentStateFacet.Enable` in their `off` list will fall back to the disabled color scheme. The `ComponentState.Enabled` will fall back to the enabled color scheme. The rest of the states will fall back to the active color scheme. This fallback behavior can be overriden as necessary by specifying a fallback color scheme in your skin definition.
