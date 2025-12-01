## Ephemeral theming - highlight painters

The highlight painter is used to paint special highlightable areas of application content. In Ephemeral, the highlight painter is using the same API as the [surface painter](surface.md). The choice of when to use the highlight painter vs the surface painter is left for the application side to decide. Some applications may decide to use different visuals for selected items in lists or grids, in which case they may opt to use the highlight painter.

In the next screenshot, Ephemeral highlight painter is used for the selected list item visuals:

<img src="https://raw.githubusercontent.com/kirill-grouchnikov/ephemeral/breeze/docs/images/component/walkthrough/box-with-highlights.png" width="300" border=0/>

Here is another example:

<img src="https://raw.githubusercontent.com/kirill-grouchnikov/ephemeral/breeze/docs/images/theming/painters/highlight/highlights.png" border=0/>

The yellow highlights in the leftmost pane and the blue highlights in the middle pane are provided by the combination of using the highlight painter and a custom application skin. The custom application skin uses:

* Registering yellow and blue color tokens as highlight color tokens on the [color tokens bundles](../skins/colortokensbundles.md) configured on these panes.
* Registering brown color tokens with the highlight  [color tokens association kind](../skins/colortokensassociationkinds.md) on the left pane.
* And the highlight painter configured to draw a flat (no gradient) highlight appearance.

### Working with highlight painters

If you wish to use the highlight painter of the current skin to provide additional custom painting in your application, call:

* Retrieve the painters associated with the current skin
* Retrieve the highlight painter of the current skin
* Use the highlight painter to paint the background on the canvas
