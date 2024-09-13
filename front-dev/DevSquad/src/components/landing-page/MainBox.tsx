import { useNavigate } from 'react-router-dom';
import style from './styles/MainBox.module.css';
import kakaoSymbol from '/assets/mainpage/kakaoSymbol.png';
import { FormEvent, useState } from 'react';

export default function MainBox() {
  const [email, setEmail] = useState<string>('');
  const [password, setPassword] = useState<string>('');
  const navigate = useNavigate();

  // 로그인 폼 제출 처리 함수
  const handleLogin = (event: FormEvent<HTMLFormElement>) => {
    event.preventDefault();
    console.log(event);
    console.log('이메일:', email);
    console.log('비밀번호:', password);

    // 대충 api 호출하고 처리 어쩌구 저쩌고
    
  };

  return (
    <div className={style.container}>
      <div className={style.loginContainer}>
        <h4 className={style.loginTitle}>뭐라 써야할까요</h4>
        <div className={style.loginInputBox}>
          {/* 로그인 폼으로 이동시키기 */}
          <form onSubmit={handleLogin}>
            <div className={style.test}>
              <div className={style.inputGroup}>
                <input name='email' placeholder='Email' value={email} onChange={(e) => setEmail(e.target.value)} className={style.inputField} required/>
                <input type="password" name="password" placeholder='Password' value={password} onChange={(e) => setPassword(e.target.value)} className={style.inputField} required/>
              </div>
              <div className={style.buttonGroup}>
                <button className={style.loginButton}>Login</button>
              </div>
            </div>
          </form>
        </div>
          {/* 회원가입 폼으로 이동시키기 */}
          <button className={style.signupButton} onClick={() => navigate("/")}>회원가입</button>
          {/* 카카오 로그인 폼으로 이동시키기 */}
          <div className={style.kakaoLoginContainer}>
            <img src={kakaoSymbol} alt="카카오심볼" className={style.kakaoSymbolImg} />
            <p className={style.kakaoLabel}>카카오 로그인</p>
          </div>
      </div>
    </div>
  );
}
