package pcrashstatistics;

/**
 * An Enumeration to represent the different speed limit types
 * @author Clayton Davidson
 *
 */
public enum SpeedLimitType {
	/**
	 * Legal max speed limit for the zone
	 */
	ENFORCED,
	/**
	 * Suggested speed for zone - usually for corners
	 */
	ADVISED,
	/**
	 * Temporarily enforced speed limit - due to exterior conditions (road works etc.)
	 */
	TEMPORARY
}
