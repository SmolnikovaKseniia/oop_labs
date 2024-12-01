from SmartHomeController import SmartHomeController

def SmartHomeUI():
    controller = SmartHomeController()
    house = "MyHouse"  # Placeholder for the house name
    exit_system = False

    print("Welcome to the Smart Home System!")
    while not exit_system:
        print("\n=== Smart Home Menu ===")
        print("1. Control Lights")
        print("2. Control Heating")
        print("3. Control Security")
        print("4. Check System Status")
        print("5. Exit")
        choice = input("Select an option: ")

        if choice == "1":
            light_choice = input("1. Turn ON Lights\n2. Turn OFF Lights\nChoose an option: ")
            if light_choice == "1":
                controller.control_lights(True)
            elif light_choice == "2":
                controller.control_lights(False)
            else:
                print("Invalid option.")

        elif choice == "2":
            heating_choice = input("1. Turn ON Heating\n2. Turn OFF Heating\nChoose an option: ")
            if heating_choice == "1":
                controller.control_heating(True)
            elif heating_choice == "2":
                controller.control_heating(False)
            else:
                print("Invalid option.")

        elif choice == "3":
            security_choice = input("1. Activate Security\n2. Deactivate Security\nChoose an option: ")
            if security_choice == "1":
                controller.control_security(True)
            elif security_choice == "2":
                controller.control_security(False)
            else:
                print("Invalid option.")

        elif choice == "4":
            print(controller.check_system_status())

        elif choice == "5":
            exit_system = True
            print("Exiting Smart Home System. Goodbye!")

        else:
            print("Invalid choice. Please try again.")
