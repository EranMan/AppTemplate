/*
 *
 *  * Copyright (C) 2014 Antonio Leiva Gordillo.
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *      http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 */

package com.eran.apptemplate.mvp.presenter;

import com.eran.apptemplate.mvp.interactor.LoginInteractor;
import com.eran.apptemplate.mvp.interactor.LoginInteractorImp;
import com.eran.apptemplate.mvp.viewinf.MainView;

/**
 * 类描述：业务类
 * 创建人： 唐僧 Eran
 * 创建时间：2016/5/3
 * 修改人： 唐僧 Eran
 * 修改时间：2016/5/3
 * 修改备注：
 */
public class MainPresenterImpl implements MainPresenter, LoginInteractor.OnFinishedListener {

    private MainView mainView;
    private LoginInteractor loginInteractor;

    public MainPresenterImpl(MainView mainView) {
        this.mainView = mainView;
        loginInteractor = new LoginInteractorImp();
    }

    @Override public void onResume() {
        if (mainView != null) {
            mainView.showProgress();
        }
        loginInteractor.login("唐僧", "123456", this);
    }

    @Override public void onItemClicked(int position) {
        if (mainView != null) {
            mainView.showMessage(String.format("Position %d clicked", position + 1));
        }
    }

    @Override public void onDestroy() {
        mainView = null;
    }


    @Override
    public void loginFinished() {

    }
}
