## Ephemeral theming - color schemes

A **color scheme** is a set of information that allows painting a control in a specific visual state. In general, a color scheme defines a collection of colors that are used by the various Ephemeral [painters](../painters/overview.md) to paint different control areas (such as background fill, border etc) under a specific visual state.

The color scheme APIs can be roughly divided in three categories:

* Base colors.
* Derived colors.
* Creating derived color schemes.

### Base colors

At the foundational level, an Ephemeral color scheme is defined with the following base colors:

* Ultra light
* Extra light
* Light
* Mid (medium)
* Dark
* Ultra dark
* Foreground

The first six colors are used to paint the background "layer" of a control, such as, for example, the background fill of a button. The foreground color is primarily used to paint the foreground "layer" of a control, such as, for example, the button text and optionally the themed button icon.

It is up to the [fill painter](../painters/fill.md) to decide which specific colors to use for the background layer, and how to use them. For example, a completely flat (non-gradient) look can be achieved by the fill painter using a single color, or by a color scheme specifying identical color values for the entire ultra light / ultra dark spectrum.

### Derived colors

In addition to the base colors, an Ephemeral color scheme has the following derived colors:

* Line
* Focus ring
* Mark
* Echo
* Background fill
* Text background fill
* Accented background fill
* Selection background
* Selection foreground
* Separator primary
* Separator secondary

The idea behind derived colors is to find the balance between consistent visuals across all surfaces painted by Ephemeral and allowing the app to customize specific colors to fit the particulars of its design language.

Let's take a look at the following UI under the core Dust Coffee skin:

<img alt="Dust Coffee"  src="https://raw.githubusercontent.com/kirill-grouchnikov/ephemeral/breeze/docs/images/theming/skins/dustcoffee1.png" width="340" height="258" />

To point out just a few places where Ephemeral is using derived colors:

* Mark color is used for the selected mark / dot of checkboxes and radio buttons, as well as the arrow of the combobox.
* Separator secondary color is used for the double content border of the tabbed pane
* Separator primary and secondary colors are used to paint the drag bump dots of the toolbar, as well as the separators in the toolbar
* Accented background fill is used to fill the scroll bar track
* Text background fill is used to fill the text field for better visual indication of editable content

Providing one or more of the derived colors in your [color schemes file](colorschemes-fileformat.md) is the recommended approach to tweaking the overall visual language of your application while maintaining continuity across different UI surfaces.

### Core light color schemes
The Ephemeral theming layer provides the following sixteen light color schemes:

Aqua, Barby Pink
<p>
<img alt="Aqua"  src="https://raw.githubusercontent.com/kirill-grouchnikov/ephemeral/breeze/docs/images/theming/colorschemes/aqua.png" width="340" height="258" />
<img alt="Barby Pink"  src="https://raw.githubusercontent.com/kirill-grouchnikov/ephemeral/breeze/docs/images/theming/colorschemes/barby-pink.png" width="340" height="258" />
</p>
Bottle Green, Brown
<p>
<img alt="Bottle Green"  src="https://raw.githubusercontent.com/kirill-grouchnikov/ephemeral/breeze/docs/images/theming/colorschemes/bottle-green.png" width="340" height="258" />
<img alt="Brown"  src="https://raw.githubusercontent.com/kirill-grouchnikov/ephemeral/breeze/docs/images/theming/colorschemes/brown.png" width="340" height="258" />
</p>
Creme, Light Aqua
<p>
<img alt="Creme"  src="https://raw.githubusercontent.com/kirill-grouchnikov/ephemeral/breeze/docs/images/theming/colorschemes/creme.png" width="340" height="258" />
<img alt="Light Aqua"  src="https://raw.githubusercontent.com/kirill-grouchnikov/ephemeral/breeze/docs/images/theming/colorschemes/light-aqua.png" width="340" height="258" />
</p>
Lime Green, Olive
<p>
<img alt="Lime Green"  src="https://raw.githubusercontent.com/kirill-grouchnikov/ephemeral/breeze/docs/images/theming/colorschemes/lime-green.png" width="340" height="258" />
<img alt="Olive"  src="https://raw.githubusercontent.com/kirill-grouchnikov/ephemeral/breeze/docs/images/theming/colorschemes/olive.png" width="340" height="258" />
</p>
Orange, Purple
<p>
<img alt="Orange"  src="https://raw.githubusercontent.com/kirill-grouchnikov/ephemeral/breeze/docs/images/theming/colorschemes/orange.png" width="340" height="258" />
<img alt="Purple"  src="https://raw.githubusercontent.com/kirill-grouchnikov/ephemeral/breeze/docs/images/theming/colorschemes/purple.png" width="340" height="258" />
</p>
Raspberry, Sepia
<p>
<img alt="Raspberry"  src="https://raw.githubusercontent.com/kirill-grouchnikov/ephemeral/breeze/docs/images/theming/colorschemes/raspberry.png" width="340" height="258" />
<img alt="Sepia"  src="https://raw.githubusercontent.com/kirill-grouchnikov/ephemeral/breeze/docs/images/theming/colorschemes/sepia.png" width="340" height="258" />
</p>
Steel Blue, Sunset
<p>
<img alt="Steel Blue"  src="https://raw.githubusercontent.com/kirill-grouchnikov/ephemeral/breeze/docs/images/theming/colorschemes/steel-blue.png" width="340" height="258" />
<img alt="Sunset"  src="https://raw.githubusercontent.com/kirill-grouchnikov/ephemeral/breeze/docs/images/theming/colorschemes/sunset.png" width="340" height="258" />
</p>
Sun Glare, Terracotta
<p>
<img alt="Sun Glare"  src="https://raw.githubusercontent.com/kirill-grouchnikov/ephemeral/breeze/docs/images/theming/colorschemes/sun-glare.png" width="340" height="258" />
<img alt="Terracotta"  src="https://raw.githubusercontent.com/kirill-grouchnikov/ephemeral/breeze/docs/images/theming/colorschemes/terracotta.png" width="340" height="258" />
</p>

### Core dark color schemes
The Ephemeral theming layer provides the following sixteen light color schemes:

Ebony, Dark Violet
<p>
<img alt="Ebony"  src="https://raw.githubusercontent.com/kirill-grouchnikov/ephemeral/breeze/docs/images/theming/colorschemes/ebony.png" width="340" height="258" />
<img alt="Dark Violet"  src="https://raw.githubusercontent.com/kirill-grouchnikov/ephemeral/breeze/docs/images/theming/colorschemes/dark-violet.png" width="340" height="258" />
</p>
Charcoal, Jade Forest
<p>
<img alt="Charcoal"  src="https://raw.githubusercontent.com/kirill-grouchnikov/ephemeral/breeze/docs/images/theming/colorschemes/charcoal.png" width="340" height="258" />
<img alt="Jade Forest"  src="https://raw.githubusercontent.com/kirill-grouchnikov/ephemeral/breeze/docs/images/theming/colorschemes/jade-forest.png" width="340" height="258" />
</p>
Ultramarine
<p>
<img alt="Ultramarine"  src="https://raw.githubusercontent.com/kirill-grouchnikov/ephemeral/breeze/docs/images/theming/colorschemes/ultramarine.png" width="340" height="258" />
</p>

### Deriving color schemes

Ephemeral provides a number of options to create derived color schemes. Note that a color scheme is a delicate balance between the foreground color and the background colors, providing visually appealing selection of colors that are designed to work together on various painters. In some cases, creating a derived color scheme (especially negated and inverted color schemes) will not result in a visually pleasing appearance.

#### Shifting a color scheme with both the background and the foreground colors

Here is the `Purple` color scheme shifted 80% towards light green in background colors and 70% towards dark red in foreground color (see the foreground color of the default button):

<img alt="Derived Shifted"  src="https://raw.githubusercontent.com/kirill-grouchnikov/ephemeral/breeze/docs/images/theming/colorschemes/derived-shifted.png" width="340" height="258" />

#### Tinting a color scheme (shifting towards white)

Here is the same `Purple` color scheme tinted 40%:

<img alt="Derived Tinted"  src="https://raw.githubusercontent.com/kirill-grouchnikov/ephemeral/breeze/docs/images/theming/colorschemes/derived-tinted.png" width="340" height="258" />

#### Toning a color scheme (shifting towards gray)

Here is the same `Purple` color scheme toned 40%:

<img alt="Derived Toned"  src="https://raw.githubusercontent.com/kirill-grouchnikov/ephemeral/breeze/docs/images/theming/colorschemes/derived-toned.png" width="340" height="258" />

#### Shading a color scheme (shifting towards black)

Here is the same `Purple` color scheme shaded 40%:

<img alt="Derived Shaded"  src="https://raw.githubusercontent.com/kirill-grouchnikov/ephemeral/breeze/docs/images/theming/colorschemes/derived-shaded.png" width="340" height="258" />

#### Saturating or desaturating a color scheme

Here is the same `Purple` color scheme saturated 40% and desaturated 40%:

<img alt="Derived Saturated"  src="https://raw.githubusercontent.com/kirill-grouchnikov/ephemeral/breeze/docs/images/theming/colorschemes/derived-saturate.png" width="340" height="258" />
<img alt="Derived Desaturated"  src="https://raw.githubusercontent.com/kirill-grouchnikov/ephemeral/breeze/docs/images/theming/colorschemes/derived-desaturate.png" width="340" height="258" />

#### Inverting a color scheme

Here is the same `Purple` color scheme inverted :

<img alt="Derived Inverted"  src="https://raw.githubusercontent.com/kirill-grouchnikov/ephemeral/breeze/docs/images/theming/colorschemes/derived-invert.png" width="340" height="258" />

#### Negating a color scheme

Here is the same `Purple` color scheme negated :

<img alt="Derived Negated"  src="https://raw.githubusercontent.com/kirill-grouchnikov/ephemeral/breeze/docs/images/theming/colorschemes/derived-negate.png" width="340" height="258" />

#### Shifting the hue of a color scheme

Here is the same `Purple` color scheme hue-shifted 40%:

<img alt="Derived Hue Shifted"  src="https://raw.githubusercontent.com/kirill-grouchnikov/ephemeral/breeze/docs/images/theming/colorschemes/derived-hueshift.png" width="340" height="258" />
