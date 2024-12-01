import SmartHome

class SmartHomeController:
    _instance = None

    def __new__(cls):
        if cls._instance is None:
            cls._instance = super(SmartHomeController, cls).__new__(cls)
            cls._instance.smart_home = SmartHome()
            print("Smart Home Controller Initialized.")
        return cls._instance

    def control_lights(self, turn_on):
        if self.smart_home.is_lights_on() == turn_on:
            print("The lights are already ON." if turn_on else "The lights are already OFF.")
        else:
            self.smart_home.set_lights_on(turn_on)
            print("The lights have been turned ON." if turn_on else "The lights have been turned OFF.")

    def control_heating(self, turn_on):
        if self.smart_home.is_heating_on() == turn_on:
            print("The heating is already ON." if turn_on else "The heating is already OFF.")
        else:
            self.smart_home.set_heating_on(turn_on)
            print("The heating has been turned ON." if turn_on else "The heating has been turned OFF.")

    def control_security(self, activate):
        if self.smart_home.is_security_on() == activate:
            print("The security system has already been ACTIVATED." if activate else "The security system has already been DEACTIVATED.")
        else:
            self.smart_home.set_security_on(activate)
            print("The security system has been ACTIVATED." if activate else "The security system has been DEACTIVATED.")

    def check_system_status(self):
        return (
            f"System Status:\n"
            f"The lights are {'ON' if self.smart_home.is_lights_on() else 'OFF'}.\n"
            f"The heating is {'ON' if self.smart_home.is_heating_on() else 'OFF'}.\n"
            f"The security system is {'ACTIVATED' if self.smart_home.is_security_on() else 'DEACTIVATED'}."
        )
