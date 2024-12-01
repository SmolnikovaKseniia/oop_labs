class SmartHome:
    def __init__(self):
        self.lights_on = False
        self.heating_on = False
        self.security_on = False

    def is_lights_on(self):
        return self.lights_on

    def set_lights_on(self, state):
        self.lights_on = state

    def is_heating_on(self):
        return self.heating_on

    def set_heating_on(self, state):
        self.heating_on = state

    def is_security_on(self):
        return self.security_on

    def set_security_on(self, state):
        self.security_on = state
