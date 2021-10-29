package org.fundaciongaliciaverde.semillas;

public class SemillasGeneralException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public SemillasGeneralException(String errorMessage) {
        super(errorMessage);
    }

    public SemillasGeneralException(String errorMessage, Throwable err) {
        super(errorMessage,err);
    }
}