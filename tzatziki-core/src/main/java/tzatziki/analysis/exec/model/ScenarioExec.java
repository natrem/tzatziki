package tzatziki.analysis.exec.model;

import static tzatziki.analysis.exec.model.StepExec.statusPassed;

/**
 * @author <a href="http://twitter.com/aloyer">@aloyer</a>
 */
public class ScenarioExec extends StepContainer {
    private final String keyword;
    private final String name;

    public ScenarioExec(String keyword, String name) {
        this.keyword = keyword;
        this.name = name;
    }

    public String name() {
        return name;
    }

    public boolean isSucess() {
        return steps().allMatch(statusPassed);
    }

    public ScenarioExec recursiveCopy() {
        ScenarioExec copy = new ScenarioExec(keyword, name);
        recursiveCopy(copy);
        return copy;
    }
}
