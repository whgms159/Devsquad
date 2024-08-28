import style from './ProjectMain.module.css';

export default function ProjectMain() {
  return (
    <div className={`${style.div1}`}>
        <div className={`${style.test}`}>전체 프로젝트</div>
        <div>
            <table className={`${style.table}`}>
                <th className={`${style.tag}`}><a href="#">태그</a></th>
                <th className={`${style.tag}`}><a href="#">태그</a></th>
                <th className={`${style.tag}`}><a href="#">태그</a></th>
                <th className={`${style.tag}`}><a href="#">태그</a></th>
            </table>
        </div>
        <div>
            <button>출시 서비스만 보기</button><button className={`${style.rigthbtn}`}>프로젝트 생성</button>
        </div>
        <div>
            <ul className={`${style.list}`}>
                <li className={`${style.li}`}>프로젝트</li>    
                <li className={`${style.li}`}>프로젝트</li>   
                <li className={`${style.li}`}>프로젝트</li>   
                <li className={`${style.li}`}>프로젝트</li>   
                <br/> <br/> <br/> <br/> <br/> <br/> <br/> 
                <li className={`${style.li}`}>프로젝트</li>   
                <li className={`${style.li}`}>프로젝트</li>   
                <li className={`${style.li}`}>프로젝트</li>   
                <li className={`${style.li}`}>프로젝트</li>   
            </ul>   
        </div>  
       
    </div>
  )
}
