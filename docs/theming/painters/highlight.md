## Ephemeral theming - highlight painters

The highlight painter is used to paint special highlightable areas of application content. The choice of when to use the highlight painter vs the fill painter is left for the application side to decide. Some applications may decide to use different visuals for selected items in lists or grids, in which case they may opt to use the highlight painter.

A highlight painter operates on:

* Component dimensions (width and height)
* Ephemeral [color scheme](../skins/colorschemes.md) to be used to compute the highlight fill colors

In the next screenshot, Ephemeral highlight painter is used for the selected list item visuals:

<img src="https://raw.githubusercontent.com/kirill-grouchnikov/ephemeral/breeze/docs/images/component/walkthrough/box-with-highlights.png" width="300" border=0/>

Here is another example:

<img src="https://raw.githubusercontent.com/kirill-grouchnikov/ephemeral/breeze/docs/images/theming/painters/highlight/highlights.png" border=0/>

The yellow highlights in the leftmost pane and the blue highlights in the middle pane are provided by the combination of using the highlight painter and a custom application skin. The custom application skin uses:

* Registering yellow and blue color schemes as highlight color schemes on the [color scheme bundles](../skins/colorschemebundles.md) configured on these panes.
* Registering a brown color scheme with a highlight border [color scheme association kind](../skins/colorschemeassociationkinds.md) on the left pane.
* And the highlight painter configured to draw a flat (no gradient) highlight appearance.

### Working with highlight painters

If you wish to use the highlight painter of the current skin to provide additional custom painting in your application, call:

* Retrieve the painters associated with the current skin
* Retrieve the highlight painter of the current skin
* Use the highlight painter to paint the background on the canvas
