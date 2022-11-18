## Window - title panes

Ephemeral supports four configurations of window title panes:

* System
* None
* Ephemeral plain
* Ephemeral integrated

### System

Under this configuration, the window title pane is provided by the operating system:

<img src="https://raw.githubusercontent.com/kirill-grouchnikov/ephemeral/breeze/docs/images/theming/titlepane/titlepane-system.png" border=0>

### None

Under this configuration, the window does not have a title pane:

<img src="https://raw.githubusercontent.com/kirill-grouchnikov/ephemeral/breeze/docs/images/theming/titlepane/titlepane-none.png" border=0>

Note that in this case, your application code is responsible for handling window move, resize, close and other top-level window interaction patterns.

### Ephemeral plain

Under this configuration, the window title pane is provided by Ephemeral:

<img src="https://raw.githubusercontent.com/kirill-grouchnikov/ephemeral/breeze/docs/images/theming/titlepane/titlepane-auroraplain.png" border=0>

In this configuration, the title pane displays app icon (if provided), app title and the window control buttons (minimize, maximize / restore and close).

This configuration provides further control over where each part of the title pane will be displayed:

| Parameter | Default value | Meaning |
| --- | --- | --- |
| **titleTextHorizontalGravity** | **Leading** | Horizontal gravity for the title |
| **titleControlButtonGroupHorizontalGravity** | **Trailing** | Horizontal gravity for the control buttons |
| **titleIconHorizontalGravity** | **OppositeControlButtons** | Horizontal gravity for the icon |

The default values for these parameters result in the layout that places:

* The control buttons on the right (**Trailing**)
* The app icon on the opposite side of the control buttons - on the left (**OppositeControlButtons**)
* The app title on the left, right after the app icon (**Leading**)

Here are a few example of configurations that you might want to consider for your applications.

Following the macOS guidelines with

* `textHorizontalGravity = HorizontalGravity.Centered`
* `controlButtonHorizontalGravity = HorizontalGravity.Leading`
* `iconHorizontalGravity = TitleIconHorizontalGravity.NextToTitle`

resulting in

<img src="https://raw.githubusercontent.com/kirill-grouchnikov/ephemeral/breeze/docs/images/theming/titlepane/titlepane-layout-macos.png" border=0>

Following the Gnome guidelines with

* `textHorizontalGravity = HorizontalGravity.Centered`
* `controlButtonHorizontalGravity = HorizontalGravity.Trailing`
* `iconHorizontalGravity = TitleIconHorizontalGravity.None`

resulting in

<img src="https://raw.githubusercontent.com/kirill-grouchnikov/ephemeral/breeze/docs/images/theming/titlepane/titlepane-layout-gnome.png" border=0>

Following the KDE guidelines with

* `textHorizontalGravity = HorizontalGravity.Centered`
* `controlButtonHorizontalGravity = HorizontalGravity.Trailing`
* `iconHorizontalGravity = TitleIconHorizontalGravity.OppositeControlButtons`

resulting in

<img src="https://raw.githubusercontent.com/kirill-grouchnikov/ephemeral/breeze/docs/images/theming/titlepane/titlepane-layout-kde.png" border=0>

### Ephemeral integrated

Under this configuration, the window title pane is provided by Ephemeral with support for integrating your application content into the window title pane:

<img src="https://raw.githubusercontent.com/kirill-grouchnikov/ephemeral/breeze/docs/images/theming/titlepane/titlepane-auroraintegrated2.png" border=0>

In this configuration, the title pane displays the window control buttons (minimize, maximize / restore and close), and provides APIs to integrate your application content.

The following configuration APIs are available:

* `titleControlButtonGroupHorizontalGravity` - horizontal gravity for the control buttons |
* `titleControlButtonGroupVerticalGravity` - vertical gravity for the control buttons |
* `titlePaneHeight` - title pane height
* `getTitlePaneControlInsets` to configure your application content to not overlap the area occupied by the title pane control buttons
* optionally, mark the part of the application content that extends into the integrated title pane with [`DecorationAreaType.TitlePane`](../skins/overview.md#decoration-areas) to be styled consistently with how Ephemeral styles plain title panes.
* optionally, use implementation-specific APIs for placing visually consistent text and buttons into the integrated title pane

Taking another look at this integrated title pane:

<img src="https://raw.githubusercontent.com/kirill-grouchnikov/ephemeral/breeze/docs/images/theming/titlepane/titlepane-auroraintegrated2.png" border=0>

we have:

* Taller than default height for the title pane to accommodate the text box
* `Leading` horizontal gravity for the control buttons
* `Centered` vertical gravity for the control buttons
* Using `getTitlePaneControlInsets` to position the "New chat" button to not overlap the control buttons
* Using `DecorationAreaType.TitlePane` to mark the part of the application content that extends into the integrated title pane, and to get consistent visuals for the "New chat" button and the text box
* Using the implementation-specific API for the consistently styled "Chat" title label

Let's take a look at another example of an integrated title pane and the moving pieces of the implementation:

<img src="https://raw.githubusercontent.com/kirill-grouchnikov/ephemeral/breeze/docs/images/theming/titlepane/titlepane-auroraintegrated1.png" border=0>

* Taller than default height for the title pane to accommodate the text box
* `Leading` horizontal gravity for the control buttons
* `Centered` vertical gravity for the control buttons
* There is no "unified" visual appearance to the title pane area, so none of these panes use `DecorationAreaType.TitlePane`. Instead, each individual pane is wrapped in its own decoration area that is used to apply a separate styling on all the elements in that pane (bluish-grey with yellow highlights in the left, metal grey with blue highlights in the middle).
* Using the implementation-specific API for the consistently styled refresh button placed into the top-right corner of the left pane.
