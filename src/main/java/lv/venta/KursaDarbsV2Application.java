package lv.venta;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lv.venta.model.Car;
import lv.venta.model.CarBrand;
import lv.venta.model.CarType;
import lv.venta.model.Client;
import lv.venta.model.Mechanic;
import lv.venta.repo.ICarRepo;
import lv.venta.repo.IClientRepo;
import lv.venta.repo.IMechanicRepo;

@SpringBootApplication
public class KursaDarbsV2Application {

	public static void main(String[] args) {
		SpringApplication.run(KursaDarbsV2Application.class, args);
	}
	
	@Bean
	public CommandLineRunner testDatabaseLayer(IClientRepo clientRepo, IMechanicRepo mechRepo, ICarRepo carRepo) {
		return new CommandLineRunner() {

			@Override
			public void run(String... args) throws Exception {
				Mechanic mech1 = new Mechanic("Karlis", "Labotajs", "21111111", (float)5, "M123456");
				mechRepo.save(mech1);
				Mechanic mech2 = new Mechanic("Lauris", "Uzgrieznis", "22111111", (float)8.4, "M654321");
				mechRepo.save(mech2);
				Client client1 = new Client("Janis", "Berzins", "23333333");
				clientRepo.save(client1);
				Client client2 = new Client("Pēteris", "Kļaviņš", "24444444");
				clientRepo.save(client2);
				Car car1 = new Car(CarBrand.Audi, "AA1234", CarType.coupe, "R8", client2, mech2);
				carRepo.save(car1);
				Car car2 = new Car(CarBrand.Opel, "AB1234", CarType.sedan, "VECTRA", client1, mech1);
				carRepo.save(car2);
				client1.addCar(car2);
				client2.addCar(car1);
				clientRepo.save(client1);
				clientRepo.save(client2);
				mech1.addCar(car2);
				mech2.addCar(car1);
				mechRepo.save(mech1);
				mechRepo.save(mech2);
			}
			
		};
	}

}
