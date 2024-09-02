import style from './styles/MainBox.module.css';
import kakaoSymbol from '/assets/mainpage/kakaoSymbol.png';

export default function MainBox() {
  return (
    <div className={style.container}>
      <div className={style.loginContainer}>
        <h4 className={style.loginTitle}>뭐라 써야할까요</h4>
        <div className={style.loginInputBox}>
          {/* 로그인 폼으로 이동시키기 */}
          <form action="">
            <div className={style.test}>
              <div className={style.inputGroup}>
                <input name='email' placeholder='Email' className={style.inputField}/>
                <input type="password" name="password" placeholder='Password' className={style.inputField}/>
              </div>
              <div className={style.buttonGroup}>
                <button className={style.loginButton}>Login</button>
              </div>
            </div>
          </form>
        </div>
          {/* 회원가입 폼으로 이동시키기 */}
          <button className={style.signupButton}>회원가입</button>
          {/* 카카오 로그인 폼으로 이동시키기 */}
          <div className={style.kakaoLoginContainer}>
            <img src={kakaoSymbol} alt="카카오심볼" className={style.kakaoSymbolImg} />
            <p className={style.kakaoLabel}>카카오 로그인</p>
          </div>
      </div>
    </div>
  );
}
