## Ephemeral theming - fill painters

A fill painter operates on:

* Shape to fill
* Ephemeral [color scheme](../skins/colorschemes.md) to be used to compute the fill colors

Important thing to note - a fill painter **does not** paint the focus ring or the border; these are painted by separately.

### Core fill painters

* **Standard** - a vertical gradient with four points:
  * The very top
  * Half height, right above
  * Half height, right below
  * The very bottom
* **Classic** - extends standard, using a less contrasty vertical gradient
* **Subdued** - extends standard, using even less contrasty vertical gradient
* **Matte** - extends gradient, with a slightly different vertical gradient
* **Glass** - extends standard, using a harder vertical gradient
* **Fraction-based** - based on an array of color query stops. Every stop has:
  * Float fraction in 0.0-1.0 range
  * Mapping from a color scheme to a specific color to use

### Working with fill painters

If you wish to use the fill painter of the current skin to provide additional custom painting in your application, call:

* Retrieve the painters associated with the current skin
* Retrieve the fill painter of the current skin
* Use the fill painter to paint the background on the canvas
