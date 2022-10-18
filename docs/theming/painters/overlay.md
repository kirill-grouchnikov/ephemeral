## Ephemeral theming - overlay painters

[Decoration painters](decoration.md) are used to paint the entire background area of the relevant containers - such as menu bars, tool bars, panels etc. Overlay painters, on the other hand, add the final polish that usually affects relatively small areas at the edges of the relevant decoration areas.

### Overlays

The overlays are best illustrated with screenshots. The following screenshot is a skeleton window under the [Nebula Brick Wall](../skins/toneddown.md#nebula-brick-wall) skin:

<img src="https://raw.githubusercontent.com/kirill-grouchnikov/ephemeral/breeze/docs/images/theming/painters/overlay/nebulabrickwall.png" width="646"/>

This skin defines custom visual appearance for the title pane, the menu bar and the status bar - the background of these areas is painted by the matching decoration painter - in this case, the `MarbleNoiseDecorationPainter`. To add the final polishing touch and create a unique visual footprint for this skin, we use a number of overlay painters. The Nebula Brick Wall skin defines two separate overlay painters, each one associated with the relevant decoration areas:

* The `TopShadowOverlayPainter` is associated with the `Toolbar` decoration area - adding the drop shadow along the top edge of all application toolbars (see the bottom half of the zoomed area in the screenshot above).
* The `BottomLineOverlayPainter` is associated with `TitlePane` and `Header` decoration areas - adding a thin separator line along the bottom edge of the title pane and the menubar (see the top half of the zoomed area in the screenshot above). Note that the application needs to specify what color is used to paint the separator line based on the matching color scheme.

Here is the same skeleton window under the [Gemini](../skins/toneddown.md#gemini) skin:

<img src="https://raw.githubusercontent.com/kirill-grouchnikov/ephemeral/breeze/docs/images/theming/painters/overlay/gemini.png" width="646"/>

This skin defines custom visual appearance for the title pane, the menu bar, the toolbars and the status bar - the background of these areas is painted by the matching [decoration painter](decoration.md) - in this case, the `MatteDecorationPainter`. To add the final polishing touch and create a unique visual footprint for this skin, we use overlay painters. The Gemini skin defines a number of overlay painters, each one associated with the relevant decoration areas:

* The double separator along the top edge of the footer (status bar) is painted by an instance of `TopBezelOverlayPainter` which is associated with the footer decoration area - see the bottom zoomed area in the screenshot above.
* The double separator between the menu bar and the tool bar is painted by two different overlay painters - see the top zoomed area in the screenshot above:
  * An instance of `BottomLineOverlayPainter` associated with header decoration area - paints the top (darker) separator line along the bottom edge of the menu bar.
  * An instance of `TopLineOverlayPainter` associated with toolbar decoration area - paints the bottom (lighter) separator line along the top edge of the tool bar.

The last example comes from the [Twilight](../skins/dark.md#twilight) skin:

<img src="https://raw.githubusercontent.com/kirill-grouchnikov/ephemeral/breeze/docs/images/theming/painters/overlay/twilight.png" width="646"/>

This skin defines custom visual appearance for the title pane, the menu bar, the toolbars and the status bar - the background of these areas is painted by the matching decoration painter - in this case, the `MatteDecorationPainter`. To add the final polishing touch and create a unique visual footprint for this skin, we use overlay painters. The Twilight skin defines a number of overlay painters, each one associated with the relevant decoration areas:

* An instance of `TopLineOverlayPainter` associated with `Toolbar` decoration area - paints the lighter top separator line along the top edge of the tool bar - see the top zoomed area in the screenshot above.
* An instance of `BottomLineOverlayPainter` associated with `Toolbar` decoration area - paints the darker bottom separator line along the bottom edge of the tool bar - see the top zoomed area in the screenshot above.
* An instance of `TopBezelOverlayPainter` associated with `Footer` decoration area - paints the double bezel separator lines along the top edge of the status bar - see the bottom zoomed area in the screenshot above.
* The instance of `BottomShadowOverlayPainter` associated with `Toolbar` and `Footer` decoration areas - paints the drop shadow along the bottom edge of these areas - see the top zoomed area in the screenshot above.

### Working with overlay painters

If you wish to use the overlay painter(s) of the current skin to provide additional custom painting in your application, call:

* Retrieve the decoration area type of the specific component
* Retrieve the painters associated with the current skin
* Retrieve the overlay painters of the current skin  registered for the specific decoration area type
* Use the decoration painter to paint the background fill of the component on the canvas

An overlay painter operates on:

* Decoration area dimensions (width and height)
* Ephemeral [color scheme](../skins/colorschemes.md) to be used to compute the overlay colors
