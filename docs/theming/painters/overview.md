## Ephemeral theming - painters overview

An Ephemeral **painter** encapsulates common painting logic. For example, in Ephemeral, borders of buttons, comboboxes, progress bars and more are painted with the same look. Instead of replicating this code across different components, it is extracted into a common painter. In addition to code reuse, it:

* Makes it easier to tweak an existing painting sequence.
* Lets applications to specify a custom (branding) painter which is applied to all relevant composables.
* Lets applications and third-party developers to provide consistent appearance of custom components without locking themselves to low-level implementation details.

Ephemeral uses four types of painters which are used on different types of controls and window areas, along with a number of core painter implementations. Interested applications can also create custom implementations of the relevant painter interfaces and combine them together in a skin that creates a unique visual appearance based on the specific design requirements.

### Painter types

Ephemeral uses the following painter types:

* [Fill painters](fill.md)
* [Border painters](border.md)
* [Decoration painters](decoration.md)
* [Overlay painters](overlay.md)

The vast majority of Ephemeral visuals are painted by using these painters.

The Ephemeral painting layer provides a convenient APIs for the applications that wish to paint custom components in a way that is consistent with other Ephemeral visuals.
