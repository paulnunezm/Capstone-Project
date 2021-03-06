package com.nunez.bookito.bookLists;

import com.google.firebase.database.DatabaseReference;
import com.nunez.bookito.entities.Book;
import com.nunez.bookito.mvp.BaseContract;

import static com.nunez.bookito.repositories.FirebaseNodes.BOOK_LISTS;

/**
 * Created by paulnunez on 3/26/17.
 */

interface BookListContract {

  interface Presenter extends BaseContract.BasePresenter {

    void getBookFromList(@BOOK_LISTS String bookListName);

    /**
     * @param option       - a delete option or the list to move the book to.
     * @param currentList  - the current list
     * @param selectedBook - the selected book
     */
    void bookListOperation(String option, String currentList, Book selectedBook);

    void SendDbReferenceToView(DatabaseReference bookListRef);

    void showNoBooksFound();

    void showBooks();
  }

  interface View extends BaseContract.BaseView {
    void setupRecyclerViewWithReference(DatabaseReference bookListRef);
  }

  interface Interactor extends BaseContract.BaseInteractor {

    void getBookFromList(@BOOK_LISTS String bookListName);

    void moveBookTo(@BOOK_LISTS String currentList, @BOOK_LISTS String listToMoveTo, Book book);

    void deleteBook(@BOOK_LISTS String bookListName, Book book);
  }

}
