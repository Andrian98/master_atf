package performance.upskilling.atf.configuration.scenario_context;

import performance.upskilling.atf.configuration.enums.Context;

import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {
//TODO to implement singleton in scenario context (study materials)
    private Map<String, Object> scenarioContext;

    public ScenarioContext(){
        scenarioContext = new HashMap<String, Object>();
    }

    public void setContext(Context key, Object value) {
        scenarioContext.put(key.toString(), value);
    }

    public Object getContext(Context key){
        return scenarioContext.get(key.toString());
    }

}
