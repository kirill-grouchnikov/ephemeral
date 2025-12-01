
# Ephemeral design system

**Ephemeral** is a design system for building modern and elegant desktop applications.

<p align="center">
<img src="https://raw.githubusercontent.com/kirill-grouchnikov/ephemeral/breeze/docs/images/theming/skins/nebula1.png" width="340" height="258" border=0>
<img src="https://raw.githubusercontent.com/kirill-grouchnikov/ephemeral/breeze/docs/images/theming/skins/gemini2.png" width="340" height="258" border=0>
</p>

<p align="center">
<img src="https://raw.githubusercontent.com/kirill-grouchnikov/ephemeral/breeze/docs/images/theming/skins/graphitechalk1.png" width="340" height="258" border=0>
<img src="https://raw.githubusercontent.com/kirill-grouchnikov/ephemeral/breeze/docs/images/theming/skins/nightshade2.png" width="340" height="258" border=0>
</p>

## Documentation

### Theming

* [Component states](docs/theming/skins/componentstates.md)
* Colors
  * [Color tokens](docs/theming/skins/colortokens.md)
  * [Color tokens association kinds](docs/theming/skins/colortokensassociationkinds.md)
  * [Color tokens bundles](docs/theming/skins/colortokensbundles.md)
* Skins
  * [Skin overview](docs/theming/skins/overview.md)
  * [Light skins](docs/theming/skins/toneddown.md)
  * [Dark skins](docs/theming/skins/dark.md)
* Painters
  * [Painter overview](docs/theming/painters/overview.md)
  * [Surface painters](docs/theming/painters/surface.md)
  * [Outline painters](docs/theming/painters/outline.md)
  * [Highlight painters](docs/theming/painters/highlight.md)
  * [Decoration painters](docs/theming/painters/decoration.md)
  * [Overlay painters](docs/theming/painters/overlay.md)
* [Themed states](docs/theming/themed-states.md)

### Window

* [Window title panes](docs/window/titlepane.md)

### Components

* Intro
  * [Basic concepts](docs/component/Intro.md)
  * [Sample app](docs/component/Sample.md)
  * [Another sample app](docs/component/AnotherSample.md)
* Commands
  * [Command overview](docs/component/Command.md)
  * [Command projections](docs/component/CommandProjections.md)
  * [Command button presentation models](docs/component/CommandButtonPresentation.md)
  * [Command popup menus](docs/component/CommandPopupMenu.md)
* Projections
  * [Model and projection overview](docs/component/ModelProjectionOverview.md)
  * [All component projections](docs/component/ComponentProjections.md)
* More components
  * [Command strips](docs/component/CommandStrip.md)
  * [Command panels](docs/component/CommandPanel.md)
  * [Breadcrumb bars](docs/component/BreadcrumbBar.md)
* Miscellaneous
  * [Context menus](docs/component/ContextMenu.md)
  * [Popup positioning](docs/component/PopupPositioning.md)
* Ribbon
  * [Overview](docs/component/RibbonOverview.md)
  * [API skeleton](docs/component/RibbonApiSkeleton.md)
  * [Working with command projections](docs/component/RibbonBandCommandProjections.md)
  * [Working with component projections](docs/component/RibbonBandComponentProjections.md)
  * [Working with galleries](docs/component/RibbonBandGalleries.md)
  * [Keytips](docs/component/RibbonKeytips.md)
  * [What happens when you resize the ribbon](docs/component/RibbonResizing.md)
  * [Application menu](docs/component/RibbonApplicationMenu.md)
  * [Anchored commands](docs/component/RibbonAnchoredCommands.md)
  * [Contextual task groups](docs/component/RibbonContextualTaskGroups.md)
  * [Taskbar](docs/component/RibbonTaskbar.md)
  * [Global contextual listener](docs/component/RibbonContextualListener.md)

## Using Ephemeral

Ephemeral is implemented in the following projects:

* [Radiance](https://github.com/kirill-grouchnikov/radiance) for Java Swing applications
* [Aurora](https://github.com/kirill-grouchnikov/aurora) for Compose applications
