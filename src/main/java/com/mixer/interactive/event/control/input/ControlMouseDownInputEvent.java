package com.mixer.interactive.event.control.input;

import com.mixer.interactive.resources.control.InteractiveControlInput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Interactive event posted by the Interactive service when a control has a <code>mousedown</code> input supplied.
 *
 * @author      Microsoft Corporation
 *
 * @since       1.0.0
 */
public class ControlMouseDownInputEvent extends ControlInputEvent {

    /**
     * Logger.
     */
    private static final Logger LOG = LoggerFactory.getLogger(ControlMouseDownInputEvent.class);

    /**
     * Keycode the participant used when interacting with the control
     */
    private final int button;

    /**
     * Initializes a new <code>ControlMouseDownInputEvent</code>.
     *
     * @param   participantID
     *          Identifier for the <code>InteractiveParticipant</code> that supplied the
     *          <code>InteractiveControlInput</code>
     * @param   transactionID
     *          Identifier for an <code>InteractiveTransaction</code> associated with the input event
     * @param   controlInput
     *          The <code>InteractiveControlInput</code> that was supplied by the <code>InteractiveParticipant</code>
     *
     * @since   1.0.0
     */
    public ControlMouseDownInputEvent(String participantID, String transactionID, InteractiveControlInput controlInput) {
        super(participantID, transactionID, controlInput);

        if (!input.getRawInput().containsKey("button")) {
            LOG.error("Could not find required parameters expected for ControlMouseDownInputEvent");
            throw new IllegalArgumentException("Could not find required parameters expected for ControlMouseDownInputEvent");
        }
        this.button = input.getRawInput().get("button").getAsInt();
    }

    /**
     * Returns the keycode the participant used when interacting with the control.
     *
     * @return  Keycode the participant used when interacting with the control
     *
     * @since   1.0.0
     */
    public int getButton() {
        return button;
    }
}
