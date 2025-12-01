## Ephemeral theming - color tokens association kinds

Color tokens association kinds in Ephemeral are best illustrated by a simple example:

<img src="https://raw.githubusercontent.com/kirill-grouchnikov/ephemeral/breeze/docs/images/theming/color-tokens-association-kinds.png" width="350" height="280"/>

This is a screenshot of a sample application UI window with a variety of Ephemeral composable controls - buttons, checkboxes, comboboxes, menu items, etc. Of a particular interest to us in this instance are controls in selected state:

* The green checkbox and radio button (with "Enabled selected" text)
* The light blue button in the bottom right corner (with "OK" text)

All three have their selected bit turned on, but the button is light blue while the other two controls tokens with different visual areas of Ephemeral controls.

The `ContainerColorTokensAssociationKind` is the base class for core and custom color tokens association kinds. Where is this class used?

* The skin definition, and more specifically the `ContainerColorTokensBundle` APIs that allow associating different color tokens with different visual areas of Ephemeral controls.
* The specific UI delegates that query the current skin for the color tokens that match the relevant visual areas of the specific control that is painted by that UI delegate.

Let's go back to our application window above. How do we use the color tokens association kinds to specify different color tokens for controls (buttons vs checkboxes and radio buttons) in selected state?

As detailed in the [skin documentation](overview.md), each skin has a number of [color tokens bundles](colortokensbundles.md). This means that two controls with the same model state (`selected` in our case) can have different visuals, depending on the [decoration areas](../painters/decoration.md) they reside in. In the definition of the specific color tokens bundle, you can specify different [color tokens](colortokens.md) for different component states. This means that a selected checkbox can use colors different from those of a rollover selected checkbox.

In our case, we want to specify different color tokens for **selected** buttons vs **selected** checkboxes in the default decoration area, using the relevant APIs in the `ContainerColorTokensBundle`.

### Fallback mechanism

The active container tokens passed to the `ContainerColorTokensBundle` constructor are used as the fallback color tokens for all active states (`ComponentState.Selected` included). The fallback mechanism also extends to the other color tokens association kinds.

The second parameter specifies what should happen when the color tokens bundle definition does not have explicitly registered color tokens for the specific color tokens association kind under the specific component state.

The registered associations are used by the Ephemeral components during the component painting. Specifically for the checkbox, the UI delegate queries `ContainerColorTokensAssociationKind.Mark` and uses the relevant painters ([surface](../painters/surface.md) and [outline](../painters/outline.md)) to paint the matching visual areas.
