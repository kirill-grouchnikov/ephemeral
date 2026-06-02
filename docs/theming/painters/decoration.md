## Ephemeral theming - decoration painters

Menu bars, tool bars, status bars - these are common examples of special containers found in application windows. These containers create functional grouping of application components and bring order to complex screens. Ephemeral theming layer provides a flexible and powerful concept to define the visual appearance of these component groups - called **decoration areas**.

At the same time, Ephemeral decoration painters enforce visual consistency and connections across the components in related areas and states.

### Decoration areas

As a picture is worth a thousand words, the following screenshots illustrate the concept of Ephemeral decoration area types.

The following screenshot is a sample application window under the Gemini skin (click to see full size version):

<img src="https://raw.githubusercontent.com/kirill-grouchnikov/ephemeral/breeze/docs/images/theming/painters/decoration/full.png" width="766"/></a>

The next screenshot shows the `title` decoration area, which in this example includes the title pane of the main window:

<img src="https://raw.githubusercontent.com/kirill-grouchnikov/ephemeral/breeze/docs/images/theming/painters/decoration/areas-title.png" width="766"/>

The next screenshot shows the `header` decoration area, which in this example includes the menu bar of the main window:

<img src="https://raw.githubusercontent.com/kirill-grouchnikov/ephemeral/breeze/docs/images/theming/painters/decoration/areas-header.png" width="766"/>

The next screenshot shows the `toolbar` decoration area, which in this example includes the tool bar of the main window:

<img src="https://raw.githubusercontent.com/kirill-grouchnikov/ephemeral/breeze/docs/images/theming/painters/decoration/areas-toolbar.png" width="766"/>

The next screenshot shows the `footer` decoration area, which in this example includes the status bar component:

<img src="https://raw.githubusercontent.com/kirill-grouchnikov/ephemeral/breeze/docs/images/theming/painters/decoration/areas-footer.png" width="766"/>

The next screenshot shows the `control pane` decoration area, which in this example includes the task pane container component:

<img src="https://raw.githubusercontent.com/kirill-grouchnikov/ephemeral/breeze/docs/images/theming/painters/decoration/areas-control-pane.png" width="766"/>

Let's go back to the original screenshot:

<img src="https://raw.githubusercontent.com/kirill-grouchnikov/ephemeral/breeze/docs/images/theming/painters/decoration/full.png" width="766"/>

It illustrates that the specific skin assigns different color tokens to different decoration areas. Components in those areas get the background and foreground colors based on their assigned color tokens (without any custom application code), thus creating visual distinction between different application areas.

### Inlay painters

Inlay painters provide the functionality of watermarks - a layer that is drawn above surfaces (background fills) but below content (texts, icons, etc).

This is how a custom inlay looks like under the Blueprint skin:

<img src="https://raw.githubusercontent.com/kirill-grouchnikov/ephemeral/breeze/docs/images/theming/painters/decoration/inlays.png" />

## Overlay painters

Overlay painters add the final polish that usually affects relatively small areas at the edges of the relevant decoration areas.

Overlays are best illustrated with screenshots. The following screenshot is a skeleton window under the [Nebula Brick Wall](../skins/toneddown.md#nebula-brick-wall) skin:

<img src="https://raw.githubusercontent.com/kirill-grouchnikov/ephemeral/breeze/docs/images/theming/painters/overlay/nebulabrickwall.png" width="646"/>

This skin defines custom visual appearance for the title pane, the menu bar and the status bar - the background of these areas is painted by the matching decoration painter - in this case, the `MarbleNoiseDecorationPainter`. To add the final polishing touch and create a unique visual footprint for this skin, we use a number of overlay painters. The Nebula Brick Wall skin defines two separate overlay painters, each one associated with the relevant decoration areas:

* The `TopShadowOverlayPainter` is associated with the `Toolbar` decoration area - adding the drop shadow along the top edge of all application toolbars (see the bottom half of the zoomed area in the screenshot above).
* The `BottomLineOverlayPainter` is associated with `TitlePane` and `Header` decoration areas - adding a thin separator line along the bottom edge of the title pane and the menubar (see the top half of the zoomed area in the screenshot above). Note that the application needs to specify what color is used to paint the separator line based on the matching color tokens.

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

### Working with decoration painters

If you wish to use the decoration painter of the current skin to provide additional custom painting in your application, call:

* Retrieve the painters associated with the current skin
* Retrieve the decoration painter of the current skin
* Retrieve the decoration area type of the specific component
* Use the decoration painter to paint the background fill of the component on the canvas

A decoration painter operates on:

* Contour to fill
* The size of the application window
* The offset of the component from the top-left corner of the application window
* Ephemeral [color tokens](../skins/colortokens.md) to be used to compute the decoration fill colors

### Working with inlay painter

If you wish to use the inlay painter of the current skin to provide additional custom painting in your application, call:

* Retrieve the decoration area type of the specific component
* Retrieve the painters associated with the current skin
* Retrieve the decoration painter of the current skin, and from it retrieve the inlay painter
* If it is not null, use the inlay painters to paint the inlay of the component on the canvas

An inlay painter operates on:

* Decoration area rectangle (offset, width and height)
* Ephemeral [color tokens](../skins/colortokens.md) to be used to compute the inlay colors

### Working with overlay painters

If you wish to use the overlay painter(s) of the current skin to provide additional custom painting in your application, call:

* Retrieve the decoration area type of the specific component
* Retrieve the painters associated with the current skin
* Retrieve the decoration painter of the current skin, and from it retrieve the overlay painters registered for the specific decoration area type
* Use the overlay painters to paint the overlays of the component on the canvas

An overlay painter operates on:

* Decoration area dimensions (width and height)
* Ephemeral [color tokens](../skins/colortokens.md) to be used to compute the overlay colors
