## Ephemeral theming - file format for defining multiple color schemes

A convenient way to define all color schemes used by an Ephemeral skin is to
bundle them all in a single text file that is then loaded and parsed at runtime.

### File format

Color schemes are defined in a plaintext format. The file itself does not have to
use any particular filename extension.

A snippet that defines a single color scheme looks like this:

```plaintext
Business Black Steel Active {
    kind=Light
    colorUltraLight=#ABCCE1
    colorExtraLight=#9EC3DB
    colorLight=#96B6CE
    colorMid=#90ABC0
    colorDark=#718091
    colorUltraDark=#747E8A
    colorForeground=#4D4D4D
}
```

Note that you have to provide values for `kind`, as well as for each one of the
seven base `color` entries.

For simpler color schemes that are used with painters that only look at a
single color - such as a flat background fill of a specific
[decoration area](../painters/decoration.md), you can use the `colorBackground`
shortcut to provide the same color for all non-foreground base colors:

```plaintext
Twilight Header Border {
    kind=Dark
    colorBackground=#000000
    colorForeground=#B9B49E
}
```

Optionally, you can specify one or more derived colors:

```plaintext
Green Magic Footer Fill {
    kind=Light
    colorBackground=#9EDDB8
    colorForeground=#5BA581
    colorSeparatorPrimary=#589288
    colorSeparatorSecondary=#CAE8BD
}
```

Here, the last three lines specify the colors for painting separators (light, dark, shadow).

### Color references

Even though some complex skins might use a lot of different color schemes,
a visually pleasant skin might not need more than a dozen or so different colors
(with, perhaps, a slight variation between two colors for subtle gradients on
certain elements). In this particular case, your color schemes can be defined
in a more compact way that does not have duplicate color value definitions
by using the following syntax.

First, start with a section that lists all your colors:

```plaintext
@colors {
    XDarkBrown=#260E07
    DarkBrown=#4D2A1D
    MediumBrown=#876250
    MediumDarkBrown=#6E4436
    ControlLight=#E2C4AA
    LightPink=#F3BAA2
}
```

Then, reference colors by names in color scheme blocks:
```plaintext
Sentinel Enabled {
    kind=Light
    colorBackground=@ControlLight
    colorForeground=@DarkBrown
}

Sentinel Disabled {
    kind=Light
    colorBackground=@ControlLight
    colorForeground=@MediumBrown
}

Sentinel Active {
    kind=Light
    colorBackground=@LightPink
    colorForeground=@DarkBrown
}
```

You can also specify two colors as "end" points for the ultra light to ultra
dark spectrum, and let Ephemeral compute the rest of the colors for you:

```plaintext
Sentinel Decorations Separator {
    kind=Dark
    colorBackground=@MediumDarkBrown->@XDarkBrown
    colorForeground=@DarkBrown
}
```

This way you can have a small collection of "core" colors define the entire
appearance of the skin. Here is a screenshot of the [Sentinel skin](toneddown.md#sentinel):

<img alt="Sentinel" src="https://raw.githubusercontent.com/kirill-grouchnikov/ephemeral/breeze/docs/images/theming/skins/sentinel1.png" width="340" height="258">

This entire skin is defined by a dozen or so core colors, and around 30 color
schemes created from these core colors.
