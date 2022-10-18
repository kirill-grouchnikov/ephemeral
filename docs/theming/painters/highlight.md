## Ephemeral theming - highlight painters

The highlight painter is used to paint special highlightable areas of application content. The choice of when to use the highlight painter vs the fill painter is left for the application side to decide. Some applications may decide to use different visuals for selected items in lists or grids, in which case they may opt to use the highlight painter.

A highlight painter operates on:

* Component dimensions (width and height)
* Ephemeral [color scheme](../skins/colorschemes.md) to be used to compute the highlight fill colors

### Working with highlight painters

If you wish to use the highlight painter of the current skin to provide additional custom painting in your application, call:

* Retrieve the painters associated with the current skin
* Retrieve the highlight painter of the current skin
* Use the highlight painter to paint the background on the canvas
