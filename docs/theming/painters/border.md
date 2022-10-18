## Ephemeral theming - border painters

Border painters are used to paint the outer contour of most components, such as buttons, check boxes, radio buttons, progress bars, tabs, scroll bars and others. This allows providing a consistent and pluggable appearance to those components.

A border painter operates on:

* Contour to draw
* Optional inner contour to draw
* Ephemeral [color scheme](../skins/colorschemes.md) to be used to compute the border colors

A particular implementation of a specific border painter may decide to ignore the inner contour if this is not relevant.

### Core border painters

* **Standard** - a vertical gradient with three points:
  * The very top
  * Half height
  * The very bottom
* **Classic** - extends standard, using a less contrasty vertical gradient
* **Flat** - extends standard, using the same color for all the points, resulting in a single-color / flat look
* **Glass** - extends standard, using a harder vertical gradient
* **Delegate** - wraps a standard border painter, applying the following on each three points:
  * Color scheme transformation - allows changing the color scheme colors with shifting, tinting, saturation, etc
  * Bitwise mask that is applied on the color returned by the transformed color scheme
* **Composite** - uses two border painters, the first one to draw the outer contour, and the second one to draw the inner contour
* **Fraction-based** - based on an array of color query stops. Every stop has:
  * Float fraction in 0.0-1.0 range
  * Mapping from a color scheme to a specific color to use
* **Delegate fraction-based** - combines color scheme transformation and bitwise masks on top of a wrapped fraction-based border painter

### Working with border painters

If you wish to use the border painter of the current skin to provide additional custom painting in your application, call:

* Retrieve the painters associated with the current skin
* Retrieve the border painter of the current skin
* Use the border painter to paint the border on the canvas
