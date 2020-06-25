package code4Schenker.ex1;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MailboxTest {
    int N = 2;
    String test_message = new String("message 1");
    String test_message_2 = new String("message 2");

    Mailbox mailbox = new Mailbox(N);

    @Test
    public void sampleInput1() throws Exception {
        try {
            mailbox.push(test_message);
            mailbox.push(test_message_2);

            mailbox.pull().equals(test_message);
            mailbox.pull().equals(test_message_2);
        } catch (Exception e) {
        }

        try {
            mailbox.pull();
            Assert.fail("Empty Mailbox");
        } catch (EmptyMailboxError error) {
            assertEquals("No messages", error.getMessage());
        }
    }
}