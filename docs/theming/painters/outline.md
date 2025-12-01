## Aurora theming - outline painters

Outline painters are used to paint the outer contour of most components, such as buttons, check boxes, radio buttons, progress bars, tabs, scroll bars and others. This allows providing a consistent and pluggable appearance to those components.

An outline painter operates on:

* Outline supplier that computes the outline to draw
* Ephemeral [color tokens](../skins/colortokens.md) to be used to compute the outline colors

A particular implementation of a specific outline painter may draw additional inner outlines for more complex visuals.

### Core outline painters

* **Fraction-based** - based on an array of color query stops. Every stop has:
  * Float fraction in 0.0-1.0 range
  * Mapping from color tokens to a specific color to use
* **Flat** - uses the same color for all the points, resulting in a single-color / flat look
* **Flat Variant** - uses the same color for all the points, resulting in a single-color / flat variant look
* **Inlay** - draws two outlines, outer and inner, using separate specs for the outlines (configurable stroke width and color token mappings)
* **Luminous** - visuals of a glassy material lit from above

### Working with outline painters

If you wish to use the outline painter of the current skin to provide additional custom painting in your application, call:

* Retrieve the painters associated with the current skin
* Retrieve the outline painter of the current skin
* Use the outline painter to paint the outline on the canvas
