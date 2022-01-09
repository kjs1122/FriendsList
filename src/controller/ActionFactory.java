package controller;

import controller.action.Action;
import controller.action.CheckFormAction;
import controller.action.FileDownLoadAction;
import controller.action.FriendsDeleteAction;
import controller.action.FriendsInsertFormAction;
import controller.action.FriendsListAction;
import controller.action.FriendsUpdateForm;
import controller.action.FriendsViewAction;
import controller.action.SuccessCheckAction;

public class ActionFactory {

	private ActionFactory() {
		
	}
	private static ActionFactory instance = new ActionFactory();
	
	public static ActionFactory getInstance() {
		return instance;
	}
	
	public Action getAction(String command) {
		Action action = null;
		
		if(command.equals("friends_list")) {
			action = new FriendsListAction();
		}
		
		if(command.equals("friends_insert_form")) {
			action = new FriendsInsertFormAction();
		}
		if(command.equals("friends_view")) {
			action = new FriendsViewAction();
		}
		if(command.equals("check_form")) {
			action = new CheckFormAction();
		}
		if(command.equals("success_check")) {
			action = new SuccessCheckAction();
		}
		if(command.equals("friends_update_form")) {
			action = new FriendsUpdateForm();
		}
		if(command.equals("friends_delete")) {
			action = new FriendsDeleteAction();
		}
		if(command.equals("file_download")) {
			action = new FileDownLoadAction();
		}

		return action;
	}
}
