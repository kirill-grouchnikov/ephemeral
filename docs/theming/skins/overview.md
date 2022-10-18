## Ephemeral theming - skins

### Introduction

A **skin** is a set of visual settings that gives your application a polished and consistent look. Ephemeral includes a number of predefined skins that can be broadly categorized as light and dark.

[Light skins](toneddown.md) use predominantly light colors for painting the UI controls and containers. [Business skin](toneddown.md#business) is an example of a light skin:

<p>
<img alt="Business" src="https://raw.githubusercontent.com/kirill-grouchnikov/ephemeral/breeze/docs/images/theming/skins/business1.png" width="340" height="258">
</p>

[Dark skins](dark.md) use predominantly dark colors for painting the UI controls and containers. [Graphite Chalk](dark.md#graphite-chalk) skin is an example of a dark skin:

<p>
<img alt="GraphiteChalk" src="https://raw.githubusercontent.com/kirill-grouchnikov/ephemeral/breeze/docs/images/theming/skins/graphitechalk1.png" width="340" height="258">
</p>

Ephemeral supports using different skins on different windows in the same application.

### Skin definition

The skin definition consists of the following:

* Decoration areas and color scheme bundles:
  * List of supported [decoration areas](../painters/decoration.md).
  * [Color scheme bundles](colorschemebundles.md) for the supported decoration areas.
  * Optional background [color schemes](colorschemes.md) for the supported decoration areas.
* Painters:
  * [Fill painter](../painters/fill.md).
  * [Border painter](../painters/border.md).
  * [Decoration painter](../painters/decoration.md).
* Miscellaneous:
  * Button shaper.
  * Optional [overlay painters](../painters/overlay.md) for some decoration areas.

In order to define a valid skin, you need to specify all its mandatory parameters. A valid skin must have a color scheme bundle for `DecorationAreaType.None`, a button shaper, a fill painter, a decoration painter, a highlight painter and a border painter. All other parts are optional.

### Decoration areas

The documentation on [decoration painters](../painters/decoration.md) explains the notion of a decoration area type. While a valid skin must define a color scheme bundle for `DecorationAreaType.None`, all other decoration area types are optional. Different skins have different sets of decoration areas that are painted. For example, the [Moderate skin](toneddown.md#moderate) decorates `DecorationAreaType.TitlePane` and `DecorationAreaType.Header`, while the [Nebula Amethyst skin](toneddown.md#nebula-amethyst) also decorates `DecorationAreaType.Toolbar`:

<p>
<img alt="Moderate" src="https://raw.githubusercontent.com/kirill-grouchnikov/ephemeral/breeze/docs/images/theming/skins/moderate1.png" width="340" height="258">
<img alt="Nebula Amethyst" src="https://raw.githubusercontent.com/kirill-grouchnikov/ephemeral/breeze/docs/images/theming/skins/nebulaamethyst1.png" width="340" height="258">
</p>

Configured decoration areas will have their background painted by the skin's [decoration painter](../painters/decoration.md) based on the default color scheme of the registered color scheme bundle.

### Overlays        
To add polishing touches to the specific decoration areas, use [overlay painters](../painters/overlay.md).

The [Nebula skin](toneddown.md#nebula) is configured to paint drop shadows on the toolbars and separators on title panes and headers:

<img alt="Nebula" src="https://raw.githubusercontent.com/kirill-grouchnikov/ephemeral/breeze/docs/images/theming/skins/nebula.png" width="340" height="258">

### Accented skins

Ephemeral provides a fine-grained mechanism for creating related skin variations by using **accented skins**.

Such skins "declare" themselves to support one particular, narrowly scoped kind of derivation - providing up to five [color schemes](colorschemes.md) as accents. It is up to a skin that declares itself as accented to "decide" how to apply those accent colors.

For example, here are two `Creme` skins that use different accents on top of the same base:

<p>
<img alt="Creme" src="https://raw.githubusercontent.com/kirill-grouchnikov/ephemeral/breeze/docs/images/theming/skins/creme1.png" width="340" height="258">
<img alt="Creme Coffee" src="https://raw.githubusercontent.com/kirill-grouchnikov/ephemeral/breeze/docs/images/theming/skins/cremecoffee1.png" width="340" height="258">
</p>

The first passes a light blue color scheme as the accent for active controls and cell highlights, while the second passes a light brown scheme as the accent for the same parts of the UI. This particular accented skin family uses these two accent types for selected tabs, checkboxes, radio buttons, default buttons, scroll bars and active cells in tables, trees, and lists.

As another example, here are two `Nebula` skins that use different accents on top of the same base:

<p>
<img alt="Nebula" src="https://raw.githubusercontent.com/kirill-grouchnikov/ephemeral/breeze/docs/images/theming/skins/nebula1.png" width="340" height="258">
<img alt="Nebula Brick Wall" src="https://raw.githubusercontent.com/kirill-grouchnikov/ephemeral/breeze/docs/images/theming/skins/nebulabrickwall1.png" width="340" height="258">
</p>

The first passes a light silver scheme as the window chrome accent, while the second passes an orange scheme as the window chrome accent. This particular accented skin family uses the window chrome accent on the root pane border, the title pane and the menu bar - while maintaining the overall consistency of its visual "language", such as decoration painter, fill painter, color scheme for active controls in the main UI area, etc.
