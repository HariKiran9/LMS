/**
 * 
 */
package preparation.swissre.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Sarvani
 *
 */

@Data
@AllArgsConstructor
public class Person implements Serializable {

	private static final long serialVersionUID = -5473365794868741028L;

	private String name;

	private String email;

	private Gender gender;

	private int age;

	private String department;

}
