public class SmartHome {
    private boolean lightsOn;
    private boolean heatingOn;
    private boolean securityOn;

    public boolean isLightsOn(String house) {
        return lightsOn;
    }

    public void setLightsOn(String house, boolean lightsOn) {
        this.lightsOn = lightsOn;
    }

    public boolean isHeatingOn(String house) {
        return heatingOn;
    }

    public void setHeatingOn(String house, boolean heatingOn) {
        this.heatingOn = heatingOn;
    }

    public boolean isSecurityOn(String house) {
        return securityOn;
    }

    public void setSecurityOn(String house, boolean securityOn) {
        this.securityOn = securityOn;
    }
}
