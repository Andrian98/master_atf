package performance.upskilling.atf.configuration.scenario_context;

import performance.upskilling.atf.configuration.enums.Context;

import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {

    private static ScenarioContext instance;

    private final Map<String, Object> scenarioContext;

    public ScenarioContext(){
        scenarioContext = new HashMap<String, Object>();
    }

    public static synchronized ScenarioContext getInstance() {
        if (instance == null) {
            instance = new ScenarioContext();
        }
        return instance;
    }

    public void setContext(Context key, Object value) {
        scenarioContext.put(key.toString(), value);
    }

    public <T> T getContext(Context key){
        return (T) scenarioContext.get(key.toString());
    }

}
