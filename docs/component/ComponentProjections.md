## Components - all projections

The full list of component projections provided by Ephemeral depends on the particular implementation of it. For example, as [Radiance](https://github.com/kirill-grouchnikov/radiance) brings Ephemeral to Swing, and Swing already has a number of common components available out of the box, Radiance "falls back" on these common components such as checkboxes, comboboxes and others, and only provides projections for components not provided by Swing.

[Aurora](https://github.com/kirill-grouchnikov/aurora) brings Ephemeral to Compose, and that particular toolkit chose to not provide any out-of-the-box components. In this particular case, Aurora provides more component projections (compared to Radiance), with the full list:

| Component | Content model | Presentation model | Projection |
| --- | --- | --- | --- |
| **Command button** | Command | CommandButtonPresentationModel | CommandButtonProjection |
| **Command button strip** | CommandGroup | CommandStripPresentationModel | CommandButtonStripProjection |
| **Command button panel** | CommandPanelContentModel | CommandPanelPresentationModel | CommandButtonPanelProjection |
| **Combobox** | ComboBoxContentModel | ComboBoxPresentationModel | ComboBoxProjection |
| **Checkbox** | SelectorContentModel | SelectorPresentationModel | CheckBoxProjection |
| **Tri-state checkbox** | TriStateSelectorContentModel | SelectorPresentationModel | TriStateCheckBoxProjection |
| **Radio button** | SelectorContentModel | SelectorPresentationModel | RadioButtonProjection |
| **Switch** | SwitchContentModel | SwitchPresentationModel | SwitchProjection |
| **Circular progress** | ProgressIndeterminateContentModel | ProgressCircularPresentationModel | CircularProgressProjection |
| **Indeterminate linear progress** | ProgressIndeterminateContentModel | ProgressLinearPresentationModel | IndeterminateLinearProgressProjection |
| **Determinate linear progress** | ProgressDeterminateContentModel | ProgressLinearPresentationModel | CircularProgressProjection |
| **Icon** | IconContentModel | IconPresentationModel | IconProjection |
| **Label** | LabelContentModel | LabelPresentationModel | LabelProjection |
| **Vertical separator** | SeparatorContentModel | SeparatorPresentationModel | VerticalSeparatorProjection |
| **Horizontal separator** | SeparatorContentModel | SeparatorPresentationModel | HorizontalSeparatorProjection |
| **Slider** | SliderContentModel | SliderPresentationModel | SliderProjection |
| **Tabs** | TabsContentModel | TabsPresentationModel | TabsProjection |
| **Text field** | TextFieldValueContentModel | TextFieldPresentationModel | TextFieldValueProjection |
| | TextFieldStringContentModel | TextFieldPresentationModel | TextFieldStringProjection |

### Next

Continue to [command strips](CommandStrip.md).
