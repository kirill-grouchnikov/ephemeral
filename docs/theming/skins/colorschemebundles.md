## Ephemeral theming - color scheme bundles

A **color scheme bundle** is a set of information that allows painting controls in a specific decoration area.

### Basics

A color scheme bundle is created with three primary color schemes - for active, enabled and disabled controls. If no state-specific color schemes are registered on the color scheme bundle, the primary color schemes are used for all component states.

Here is a screenshot of three buttons (active, enabled and disabled) under the core [Business Black Steel](toneddown.md#businessblacksteel):

<img src="https://raw.githubusercontent.com/kirill-grouchnikov/ephemeral/breeze/docs/images/theming/states/control-states.png" width="284" height="101" />

### More states

In addition to the three primary color schemes, Ephemeral allows specifying which color scheme(s) should be used for components in specific component state(s).

For example, you can use this API if you want to visualy distinguish between buttons in rollover state and rollover selected state. Here is a screenshot of buttons in different states under the emulated Office Silver 2007 skin:

<img src="https://raw.githubusercontent.com/kirill-grouchnikov/ephemeral/breeze/docs/images/theming/states/control-states-extended.png" width="275" height="279" />

Here, we use five different color schemes for the following component states:

* `ComponentState.RolloverUnselected`
* `ComponentState.RolloverSelected`
* `ComponentState.Selected`
* `ComponentState.PressedUnselected`
* `ComponentState.PressedSelected`

It is possible to specify a custom alpha value for components in certain states. This can be useful if you want to use the same color scheme for both enabled and disabled states, and have disabled controls painted with a custom alpha translucency (making them blend with the background).

### Highlights

The [highlight painters](../painters/highlight.md) are used to paint highlight areas of relevant components.

### Finer grained control

As described in the [color scheme association kind documentation](colorschemeassociationkinds.md), Ephemeral components have different visual areas. Even such a simple example as a checkbox icon has three different visual areas: inner fill, border and the "V" mark:

<img src="https://raw.githubusercontent.com/kirill-grouchnikov/ephemeral/breeze/docs/images/theming/color-scheme-association-kinds.png" width="96" height="96"/>

You can specify which color scheme should be used for specific visual areas under specific component states, expressing something like "Use the Light Gray color scheme for the borders of disabled selected and disabled unselected components".

### Derived bundles

It is possible to create a derived color scheme bundle. Note that a color scheme bundle is a delicate collection of different color schemes and alpha values carefully chosen to work together in providing visually appealing appearance and consistent animation sequences. In some cases, creating a derived color scheme bundle will result in poor visuals.
