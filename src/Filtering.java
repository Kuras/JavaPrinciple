/**
 * Created by pkura on 2016-03-10.
 */
public interface Filtering {
    /**
     * public static final == constant
     * simple implementations only use
     * -- so a filtering interface --
     * could
     *  => break encapsulation
     */
    public static final String ALLOW_ALL = "ALLOW_ALL";
    public static final String ALLOW_NONE= "ALLOW_NONE";
}
