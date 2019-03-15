package test;

/**
 * @author swapnil.suhane on Mar, 2019
 */
public enum Status {
    /* Initial Invoice status */
    NEW,

    /* Just before sending for invoice processing */
    READY_TO_SEND,

    /* Failed in preparing data before RTS */
    READY_TO_SEND_FAILED,

    /* Invoice sending to customer */
    SENDING,

    /* Invoice data sending to customer failed */
    SENDING_FAILED,

    /* Invoice sent to customer successfully [Final Status]*/
    SENT,

    /* Invoice sent to customer failed */
    SENT_FAILED

}
