## Ephemeral theming - color tokens bundles

A **color tokens bundle** is a set of information that allows painting controls in a specific decoration area. The `ContainerColorTokensBundle` contains all the APIs officially supported by Aurora color tokens bundles.

### Basics

The `ComponentState` is the base class for core and custom [component states](componentstates.md). A color tokens bundle is created with three major color tokens - for active, muted and neutral containers. If no state-specific color tokens are registered on the color tokens bundle, the major color tokens are used for all component states.

Here is a screenshot of three buttons (active, enabled and disabled) under the core [Cerulean skin](light-skins.md#cerulean):

<img src="https://raw.githubusercontent.com/kirill-grouchnikov/ephemeral/breeze/docs/images/theming/states/component-states-basic.png" width="306" height="138" />

### More states

In addition to the three primary color tokens, Ephemeral allows specifying which color tokens should be used for components in specific component state(s).

For example, you can use this API if you want to visualy distinguish between buttons in rollover state and rollover selected state. Here is a screenshot of buttons in different states under the emulated Office Silver 2007 skin:

<img src="https://raw.githubusercontent.com/kirill-grouchnikov/ephemeral/breeze/docs/images/theming/states/component-states-extended.png" width="306" height="286" />

Here, we use five different color tokens for the following component states:

* `ComponentState.RolloverUnselected`
* `ComponentState.RolloverSelected`
* `ComponentState.Selected`
* `ComponentState.PressedUnselected`
* `ComponentState.PressedSelected`

### Highlights

The [highlight painters](../painters/highlight.md) are used to paint highlight areas in components as lists, tables, table headers, trees and menus.

Use `ContainerColorTokensAssociationKind.Highlight` to register color tokens to be used for higlighted visuals.
