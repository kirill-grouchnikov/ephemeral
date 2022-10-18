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

It illustrates that the specific skin assigns different color schemes to different decoration areas. Components in those areas get the background and foreground colors based on their assigned color scheme (without any custom application code), thus creating visual distinction between different application areas.

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
* Ephemeral [color scheme](../skins/colorschemes.md) to be used to compute the decoration fill colors
