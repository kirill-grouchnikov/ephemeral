## Components - popup positioning

<img src="https://raw.githubusercontent.com/kirill-grouchnikov/ephemeral/breeze/docs/images/component/walkthrough/command-secondary-simple.png" width="652" border=0/>

The examples shown in the [command popup menu](CommandPopupMenu.md) documentation have one thing in common - all the popups are displayed under their anchor component and are left aligned to the left edge of that anchor.

In some cases, you may want to apply different placement and alignment of your popup content.

### Placement and alignment

Apart from the [context menus](ContextMenu.md), Ephemeral popups are displayed as the result of the user interacting with a popup activation area of a certain component, such as a combobox, a command button or any other relevant piece of UI. In Ephemeral, such an activation area is always a rectangle, and the rest of this documentation will be referring to its edges as:

* Along the X axis, **start** and **end** edge. This is a common terminology that respects the two different component orientations - left-to-right (LTR) and right-to-left (RTL).
  * Under LTR, the left edge of the component is its start, and the right edge is its end
  * Under RTL, the right edge of the component is its start, and the left edge is its end
* Along the Y axis, **top** and **bottom**

Placement and alignment of popup content refer to these two axes, which we will call the **major** positioning axis and the **minor** positioning axis. Let's see a couple of examples.

<img src="https://raw.githubusercontent.com/kirill-grouchnikov/ephemeral/breeze/docs/images/component/walkthrough/popup-placement-alignment.png" width="332" height="205" border=0/>

In this case, the "Share" popup command button is placed close to the end edge of the application window (right edge under the LTR component orientation). The design decision here is to display the popup content under the activation area (**placement**), aligning its end edge to the end edge of that activation area (**alignment**).

<img src="https://raw.githubusercontent.com/kirill-grouchnikov/ephemeral/breeze/docs/images/component/walkthrough/popup-placement-upward.png" width="510" border=0/>

This combobox is placed along the bottom edge of the window. The design decision here is to display the popup content above the activation area (**placement**), aligning its start edge to the start edge of that activation area (**alignment**).

### Available configuration options

`PopupPlacementStrategy` encapsulates all available options to place and align popup content. Every available placement strategy combines two things:

* **Placement** - the positioning of the popup content along the major axis relative to its anchor area
* **Alignment** - the positioning of the popup content along the minor axis relative to its anchor area

The available options are:

* **Upward** placement - positioned above the anchor area
  * with **HAlignStart** alignment - and having its start edge aligned to the start edge of the anchor area
  * with **HAlignEnd** alignment - and having its end edge aligned to the end edge of the anchor area
* **Downward** placement - positioned under the anchor area
  * with **HAlignStart** alignment - and having its start edge aligned to the start edge of the anchor area
  * with **HAlignEnd** alignment - and having its end edge aligned to the end edge of the anchor area
* **CenteredVertically** placement - with the vertical center point of the popup at the same Y position as the vertical center of the anchor area
  * with **HAlignStart** alignment - and having its start edge aligned to the start edge of the anchor area
  * with **HAlignEnd** alignment - and having its end edge aligned to the end edge of the anchor area
* **Startward** placement - positioned next to the start edge of the anchor area (to the left side under LTR, to the right side under RTL)
  * with **VAlignTop** alignment - and having its top edge aligned to the top edge of the anchor area
  * with **VAlignBottom** alignment - and having its bottom edge aligned to the bottom edge of the anchor area
* **Endward** placement - positioned next to the end edge of the anchor area (to the right side under LTR, to the left side under RTL)
  * with **VAlignTop** alignment - and having its top edge aligned to the top edge of the anchor area
  * with **VAlignBottom** alignment - and having its bottom edge aligned to the bottom edge of the anchor area  

Taking another look at the examples above:

<img src="https://raw.githubusercontent.com/kirill-grouchnikov/ephemeral/breeze/docs/images/component/walkthrough/popup-placement-alignment.png" width="332" height="205" border=0/>

This is using `Downward.HAlignEnd`

<img src="https://raw.githubusercontent.com/kirill-grouchnikov/ephemeral/breeze/docs/images/component/walkthrough/popup-placement-upward.png" width="510" border=0/>

And this is using `Upward.HAlignStart`
