## Ephemeral theming - fill painters

A fill painter operates on:

* Shape to fill
* Ephemeral [color scheme](../skins/colorschemes.md) to be used to compute the fill colors

Important thing to note - a fill painter **does not** paint the focus ring or the border; these are painted by separately.

### Core fill painters

* **Fraction-based** - based on an array of color query stops. Every stop has:
  * Float fraction in 0.0-1.0 range
  * Mapping from a color scheme to a specific color to use
* **Classic** - uses a less contrasty vertical gradient
* **Subdued** - uses even less contrasty vertical gradient
* **Matte** - uses with a slightly different vertical gradient
* **Glass** - uses using a harsher vertical gradient

### Working with fill painters

If you wish to use the fill painter of the current skin to provide additional custom painting in your application, call:

* Retrieve the painters associated with the current skin
* Retrieve the fill painter of the current skin
* Use the fill painter to paint the background on the canvas
