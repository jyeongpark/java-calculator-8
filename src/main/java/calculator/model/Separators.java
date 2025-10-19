package calculator.model;

import calculator.constants.Constants;
import calculator.enums.DefaultSeparator;
import calculator.enums.Message;
import java.util.List;
import java.util.stream.Collectors;

public class Separators {
    private final List<Separator> separators;

    public Separators(List<String> candidateSeparators) {
        validateSeparators(candidateSeparators);
        this.separators = toUniqueSeparators(candidateSeparators);
    }

    public Separators(List<String> candidateSeparators, String candidateCustomSeparator) {
        final Separator customSeparator = validCustomSeparator(candidateCustomSeparator);
        validateSeparators(candidateSeparators, customSeparator);
        this.separators = toUniqueSeparators(candidateSeparators);
    }

    private void validateSeparators(final List<String> candidateSeparators) {
        if (candidateSeparators.stream().anyMatch(DefaultSeparator::isNotDefaultSeparator)) {
            throw new IllegalArgumentException(Message.NOT_ALLOWED_SEPARATOR.getValue());
        }
    }

    private void validateSeparators(final List<String> candidateSeparators, final Separator customSeparator) {
        if (candidateSeparators.stream()
                .anyMatch(candidate -> isNotAllowedSeparator(candidate, customSeparator))) {
            throw new IllegalArgumentException(Message.NOT_ALLOWED_SEPARATOR.getValue());
        }
    }

    private boolean isNotAllowedSeparator(final String candidate, final Separator customSeparator) {
        return DefaultSeparator.isNotDefaultSeparator(candidate)
                && (!candidate.equals(customSeparator.getValue()));
    }

    private Separator validCustomSeparator(String candidateCustomSeparator) {
        if (DefaultSeparator.isDefaultSeparator(candidateCustomSeparator)) {
            throw new IllegalArgumentException(Message.NOT_ALLOWED_CUSTOM_SEPARATOR.getValue());
        }

        return new Separator(candidateCustomSeparator);
    }

    private List<Separator> toUniqueSeparators(final List<String> candidateSeparators) {
        return candidateSeparators.stream()
                .distinct()
                .map(Separator::new)
                .toList();
    }

    public String getSplitRegex() {
        return separators.stream()
                .map(Separator::getValue)
                .collect(Collectors.joining(Constants.OR));
    }
}