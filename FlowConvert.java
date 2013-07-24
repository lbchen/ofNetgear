getActions(){

  /* Added by lbc 072313 */
                if (action.getType() == ActionType.ENQUEUE) {
                  Enqueue eq = (Enqueue) action;
                	OFActionEnqueue enqueue = new OFActionEnqueue();
                	enqueue.setPort(eq.getPort());
                	enqueue.setQueueId(eq.getQueueid());
                	enqueue.setLength(U16.t(OFActionEnqueue.MINIMUM_LENGTH));
                	actionsList.add(enqueue);
                	actionsLength += OFActionEnqueue.MINIMUM_LENGTH;
                	continue;
                }
                /* Added by lbc 072313 */

}
