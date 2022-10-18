## Ephemeral theming - themed states

### Introduction

Ephemeral supports animating state transitions for its components.

Let's take a look at this screenshot from the [component states](skins/componentstates.md) documentation:

<img src="https://raw.githubusercontent.com/kirill-grouchnikov/ephemeral/breeze/docs/images/theming/states/control-states-extended.png"
width="275" height="279"/>

Here we see how an Ephemeral skin (that implements some parts of Office Silver 2007 look) provides different visuals for different component states - light yellow for rollover, light orange for selected, deeper orange for pressed, etc. As the component - such as a button in this case - reacts to the user interaction and changes state, the component smoothly animates its visuals to reflect the new state. In the case of our button, that includes the inner fill, the border and the text.

This comes particularly handy for skins that mix light and dark visuals for different states of the same component. Here is the same UI under the Magellan skin:

<img src="https://raw.githubusercontent.com/kirill-grouchnikov/ephemeral/breeze/docs/images/theming/states/control-states-extended-mix.png"
width="275" height="279"/>

Note how the selected button uses light text on dark background, while the rollover selected button uses dark text on light background. If your UI uses the Magellan skin (or any other skin that uses a mix of light and dark color schemes), an Ephemeral skin will do the right thing to animate all relevant parts of your UI as the user interacts with it.

What about the icons?

### Theming icons

<img src="https://raw.githubusercontent.com/kirill-grouchnikov/ephemeral/breeze/docs/images/theming/skins/nebulaamethyst1.png"
width="340" height="258"/>

This is a screenshot of a small demo app running under the Nebula Amethyst skin. As UIs with lots of icons can get pretty busy, Ephemeral provides APIs to theme the icons based on the current skin visuals.

All Ephemeral APIs that accept icons also accept an optional `IconFilterStrategy` parameter. Depending on where the specific icon is used, you can specify up to three icon filter strategies that apply for components / icons in three states:

 * Disabled
 * Enabled
 * Active (any combination of rollover, pressed, selected)

Three icon filtering strategies are supported:
 * `IconFilterStrategy.Original` - leave the icon as supplied by the application with no filtering applied
 * `IconFilterStrategy.ThemedFollowText` - filter the icon to use the text color that matches the current component state
 * `IconFilterStrategy.ThemedFollowColorScheme` - filter the icon to use the Ephemeral color scheme from the currently set skin that matches the component in its current state

`ThemedFollowColorScheme` which works best for multi-color / multi-tone icons and Ephemeral skins with multi-color color schemes. Here is the same UI with this icon filter strategy applied on enabled and disabled component states:

<img src="https://raw.githubusercontent.com/kirill-grouchnikov/ephemeral/breeze/docs/images/theming/skins/nebulaamethyst_filtered1.png"
width="340" height="258"/>

Take a look at the icons in the toolbar. The icon for the active / selected button (paste) is still in full original color, but the rest of the icons have been themed with the colors of the enabled color scheme configured for the toolbar area of the Nebula Amethyst skin. This works well in this particular case because:

* The original Tango icons have enough contrast to continue being easily recognizable when they are themed in what is essentially a mono-chrome purple color palette
* Nebula Amethyst skin uses color schemes with different background colors for the ultra light to ultra dark range, so that when these colors are used to theme the original icons, the icons remain crisp and legible.

`ThemedFollowText` works best for single-tone icons found in such popular icon packs as [Material](https://material.io/resources/icons/), [Ionicons](https://ionicons.com/), [Friconix](https://friconix.com/), [Flexicons](https://setproduct.com/flexicons), [Font Awesome](https://fontawesome.com/) and many others:

<img src="https://raw.githubusercontent.com/kirill-grouchnikov/ephemeral/breeze/docs/images/theming/states/control-states-extended-themed.png"
width="281" height="279"/>

In this screenshot of the same UI from earlier under the Magellan skin, all the buttons use the same help icon from the Material icon pack. At runtime, each button's is filtered icon to follow the foreground / text color of the button for a consistent look across all component states.
