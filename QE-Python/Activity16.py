class Car:
    def __init__(self,manufracturer,model,make,transmission,color):
        self.manufracturer=manufracturer
        self.model=model
        self.make=make
        self.transmission=transmission
        self.color=color
    def accelerate(self):
        print(f'{self.manufracturer} {self.model} is moving')
    def stop(self):
        print(f"{self.manufracturer} {self.model} has stopped")
car1=Car("Toyota","Innova",2022,"Automatic","white")
car2=Car("Hyundai","i20",2021,"Manual","Red")
car3=Car("Tata","Nexon",2023,"Automatic","Blue")
car1.accelerate()
car1.stop()
car2.accelerate()
car2.stop()
car3.accelerate()
car3.stop()
