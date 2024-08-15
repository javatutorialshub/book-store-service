package com.javatutorialshub.bookstore.app.module;

import com.google.inject.AbstractModule;
import com.google.inject.matcher.Matchers;
import com.javatutorialshub.bookstore.core.feature.find.byid.FindBookByIdComponent;
import com.javatutorialshub.bookstore.core.feature.find.byid.IFindBookByIdComponent;
import com.javatutorialshub.bookstore.core.feature.find.byid.port.IFindBookByIdPort;
import com.javatutorialshub.bookstore.core.feature.update.IUpdateBookComponent;
import com.javatutorialshub.bookstore.core.feature.update.UpdateBookComponent;
import com.javatutorialshub.bookstore.core.feature.update.port.IUpdateBookPort;
import com.javatutorialshub.bookstore.infra.feature.find.book.adapter.FindBookByIdAdapter;
import com.javatutorialshub.bookstore.infra.feature.update.book.adapter.UpdateBookAdapter;

public class UpdateBookModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(IFindBookByIdPort.class).to(FindBookByIdAdapter.class);
        bind(IFindBookByIdComponent.class).to(FindBookByIdComponent.class);
        bindInterceptor(Matchers.subclassesOf(IFindBookByIdComponent.class), Matchers.any(), new MethodValidationInterceptor());

        bind(IUpdateBookPort.class).to(UpdateBookAdapter.class);
        bind(IUpdateBookComponent.class).to(UpdateBookComponent.class);
        bindInterceptor(Matchers.subclassesOf(IUpdateBookComponent.class), Matchers.any(), new MethodValidationInterceptor());
    }
}
