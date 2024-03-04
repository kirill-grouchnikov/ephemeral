## Ephemeral theming - border painters

Border painters are used to paint the outer contour of most components, such as buttons, check boxes, radio buttons, progress bars, tabs, scroll bars and others. This allows providing a consistent and pluggable appearance to those components.

A border painter operates on:

* Contour to draw
* Optional inner contour to draw
* Ephemeral [color scheme](../skins/colorschemes.md) to be used to compute the border colors

A particular implementation of a specific border painter may decide to ignore the inner contour if this is not relevant.

### Core border painters

* **Fraction-based** - based on an array of color query stops. Every stop has:
  * Float fraction in 0.0-1.0 range
  * Mapping from a color scheme to a specific color to use
* **Delegate fraction-based** - combines color scheme transformation and bitwise masks on top of a wrapped fraction-based border painter
* **Classic** - uses the same color for all the points, resulting in a single-color / flat look
* **Flat** - uses the same color for all the points, resulting in a single-color / flat look
* **Glass** - uses the same color for all the points, resulting in a single-color / flat look
* **Composite** - uses two border painters, the first one to draw the outer contour, and the second one to draw the inner contour

### Working with border painters

If you wish to use the border painter of the current skin to provide additional custom painting in your application, call:

* Retrieve the painters associated with the current skin
* Retrieve the border painter of the current skin
* Use the border painter to paint the border on the canvas
