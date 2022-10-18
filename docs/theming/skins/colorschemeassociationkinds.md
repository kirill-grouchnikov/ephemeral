## Ephemeral theming - color scheme association kinds

Color scheme association kinds in Ephemeral are best illustrated by the following example:

<img src="https://raw.githubusercontent.com/kirill-grouchnikov/ephemeral/breeze/docs/images/theming/color-scheme-association-kinds.png" width="96" height="96"/>

This is a screenshot of a checkbox icon under 72 point font. This checkmark icon has three different visual areas: inner fill, border and the "V" mark. Each one of these areas is painted with a different [color scheme](colorschemes.md), and this is allowed by using the relevant **color scheme association kinds**.

Where are color scheme association kinds used?

* The first usage is in the skin definition - to associate different color schemes with different visual areas of components.
* The drawing code of specific components that queries the current skin for the color schemes that match the relevant visual areas.

Let's go back to the checkbox icon example above. How do we use the color scheme association kinds to specify three different color schemes for painting this checkmark icon?

As detailed in the [skin documentation](overview.md), each skin has a number of [color scheme bundles](colorschemebundles.md). This means that two checkboxes with the same model state (`selected` in our case) can have different visuals, depending on the [decoration areas](../painters/decoration.md) they reside in. In the definition of the specific color scheme bundle, you can specify different [color schemes](colorschemes.md) for different component states. This means that a selected checkbox can use colors different from those of a rollover selected checkbox.

In our case, we want to specify different color schemes for different visual areas of **selected** checkboxes in the default decoration area.

* The inner fill is specified by the `ColorSchemeAssociationKind.Fill`
* The border is specified by the `ColorSchemeAssociationKind.Border`
* The mark is specified by the `ColorSchemeAssociationKind.Mark`

### Fallback mechanism

The fallback mechanism specifies what should happen when the color scheme bundle definition does not have an explicitly registered color scheme for the specific color scheme association kind under the specific component state.

For example, the `ColorSchemeAssociationKind.Mark` has the `ColorSchemeAssociationKind.Border` as its fallback. This means that if you want to use the same color scheme for painting both borders and marks, you only need to specify the color scheme for the  `ColorSchemeAssociationKind.Border` value.

The registered association kinds are used by Ephemeral at runtime when the component is painted. Specifically for the checkbox, the drawing code queries the three relevant association kinds (`ColorSchemeAssociationKind.Fill`, `ColorSchemeAssociationKind.Border` and `ColorSchemeAssociationKind.Mark`) and uses the relevant painters ([fill](../painters/fill.md) and [border](../painters/border.md)) to paint the matching visual areas.
