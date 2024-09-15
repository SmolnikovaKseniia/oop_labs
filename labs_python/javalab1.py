import math

class NumberOperations:

    def add_to_list(self, numbers, integer_num, float_num, byte_num, short_num, long_num, double_num):
        numbers.extend([double_num, integer_num, float_num, byte_num, short_num, long_num])


    def remake_array_to_int(self, numbers):
        print("  a. Всі числа переведені в Integer: [", end="")
        for i, num in enumerate(numbers):
            if i == len(numbers) - 1:
                print(int(num), end="]\n")
            else:
                print(int(num), end=", ")


    def remake_array_to_float(self, numbers):
        print("  b. Всі числа переведені в Float: [", end="")
        for i, num in enumerate(numbers):
            if i == len(numbers) - 1:
                print(f"{float(num):.2f}", end="]\n")
            else:
                print(f"{float(num):.2f}", end=", ")

    def add_num_by_type(self, number, int_list, float_list, short_list, byte_list, double_list, long_list):
        print("2. ", end="")
        if isinstance(number, int):
            int_list.append(number)
            print("Число додано у список Integer")
        elif isinstance(number, float):
            float_list.append(number)
            print("Число додано у список Float")

    # Method to calculate the sum of the square roots
    def sum_of_sqrt(self, number_list):
        total_sum = sum(math.pow(num, 2) for num in number_list)
        print(f"3. Сума квадратів елементу списку: {total_sum}")

def main():

    integer_num = 3000
    float_num = 3.43
    byte_num = 1
    short_num = 2
    long_num = 243234234
    double_num = -34243424.3434432

    int_list = []
    float_list = []
    byte_list = []
    short_list = []
    double_list = []
    long_list = []

    numbers = [10.0, 20.5, 30.0, 40.7, 50.0, 60.3, 70.0, 80.1, 90.0, 100.9]

    operations = NumberOperations()
    

    operations.add_to_list(numbers, integer_num, float_num, byte_num, short_num, long_num, double_num)
    print(f"1. Всі числа: {numbers}")
    
    operations.remake_array_to_int(numbers)
    operations.remake_array_to_float(numbers)
    
    operations.add_num_by_type(double_num, int_list, float_list, short_list, byte_list, double_list, long_list)
    operations.sum_of_sqrt(numbers)

if __name__ == "__main__":
    main()
