/*
 * Copyright 2012-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package war.data.jpa;

import static java.lang.System.exit;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import war.data.jpa.domain.City;
import war.data.jpa.service.ICityService;

@SpringBootApplication // = @Configuration + @ComponentScan + @EnableAutoConfiguration + ect....
public class SampleDataJpaApplication implements CommandLineRunner {

    @Autowired
	private ICityService iCityService;

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SampleDataJpaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    	if(args == null || (args != null && args.length <= 0)) {
    		args = new String[]{"display"}; 
    	}
    	
    	// for testing - Disable following two lines if you run from command line
    	args = new String[]{"insert"};
    	//args = new String[]{"display"}; 

        if (args.length <= 0) {
            System.err.println("[Usage] java <xyxz>.jar {insert | display}");
        } else {
            if (args[0].equalsIgnoreCase("insert")) {
                System.out.println("Add City...");
               
                iCityService.addCity(new City(null, "Bangalore", "KA", "INDIA", "-12121, -13213232"));
                iCityService.addCity(new City(null, "Marathahalli", "KA", "INDIA", "-454454, -45454545"));
                
                args = new String[]{"display"};
            }

            if (args[0].equalsIgnoreCase("display")) {
            	
                System.out.println("Display all City...");
                
                List<City> list = iCityService.getAllCity();
                list.forEach(x -> System.out.println(x));
            }
            System.out.println("Done!");
        }
        exit(0);
    }
}