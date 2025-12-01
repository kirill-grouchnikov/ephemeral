## Ephemeral theming - surface painters

A surface painter operates on:

* Outline to fill
* Ephemeral [color tokens](../skins/colortokens.md) to be used to compute the colors.

Important thing to note - a surface painter **does not** paint the focus ring or the outline; these are painted by separately.

### Core surface painters

* **Fraction-based** - based on an array of color query stops. Every stop has:
  * Float fraction in 0.0-1.0 range
  * Mapping from color tokens to a specific color to use
* **Classic** - uses a less contrasty vertical gradient
* **Glass** - uses using a harsher vertical gradient
* **Matte** - uses with a slightly different vertical gradient
* **Luminous** - visuals of a glassy material lit from above
* **Specular** - visuals of a plastic material lit from above

### Working with surface painters

If you wish to use the surface painter of the current skin to provide additional custom painting in your application, call:

* Retrieve the painters associated with the current skin
* Retrieve the surface painter of the current skin
* Use the surface painter to paint the surface on the canvas
