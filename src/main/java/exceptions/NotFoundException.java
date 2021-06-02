package exceptions;


import util.MessageUtils;

/*public class NotFoundException extends RuntimeException {
	
	public NotFoundException() {
		super(MessageUtils.NO_RECORDS_FOUND);
	}
	

}
*/
public class NotFoundException extends RuntimeException {

    public NotFoundException() {
        super(MessageUtils.NO_RECORDS_FOUND);
    }
}
