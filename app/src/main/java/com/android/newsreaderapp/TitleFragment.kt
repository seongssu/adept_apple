package com.android.newsreaderapp

import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.core.view.ViewCompat.NestedScrollType
import androidx.fragment.app.setFragmentResult
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.newsreaderapp.databinding.FragmentTitleBinding


class TitleFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding =FragmentTitleBinding.inflate(inflater,container,false)
        val view = binding.root

        val newsList = mutableListOf<NewsItem>()
        newsList.add(NewsItem(R.drawable.news1,"2026학년도 대입부터 학폭가해 의무 반영…지원자격 배제도 가능\n","(세종=연합뉴스)" +
                " 김수현 " +
                "기자 = 현재" +
                " 고등학교 1학년이 치르는 2026학년도 대학 입학전형부터 학교 폭력(학폭) 가해 학생에 대한 조치 결과가 수시는 물론 정시에도 반영된다.\n" +
                "\n" +
                "학폭 조치 사항 기재만으로 지원 자격을 배제하는 학교도 나올 것으로 보인다.\n" +
                "\n" +
                "학폭 조치로 인한 불이익을 우려해 자퇴하는 우회로를 차단하기 위해 검정고시생에게도 각 대학이 학교생활기록부(학생부) 제출을 요구할 수 있게 된다.\n" +
                "\n" +
                "한국대학교육협의회(대교협)는 대학입학전형위원회의 최종심의·의결을 거쳐 '2026학년도 대학 입학전형 기본사항'을 30일 확정·발표했다.","2023-08-30 15:37" ))

        newsList.add(NewsItem(R.drawable.news2,"서울 미아동서 40대 여성 112신고 후 숨진 채 발견", "(서울=연합뉴스) 김정진 " +
                "기자 = " +
                "서울 강북구에서 40대 남녀가 숨진 채 발견돼 경찰이 수사에 착수했다. 경찰은 이들이 시신으로 발견되기 전 여성의 휴대전화로 발신된 112 신고를 접수했으나 소재를 파악하지 못하고 있었다.\n" +
                "\n" +
                "30일 경찰 등에 따르면 지난 28일 오후 8시55분께 강북구 미아동 한 빌라에서 40대 여성 A씨가 40대 남성 B씨와 함께 숨져 있는 것을 신고받고 출동한 소방당국이 확인했다.\n" +
                "\n" +
                "가족은 빌라 2층에 있는 A씨 집을 찾아갔다가 문이 잠겨 있자 창문 바깥에 사다리를 대고 집 안에 쓰러져 있는 A씨를 발견해 119에 신고했다.\n" +
                "\n" +
                "A씨는 양손이 청테이프로 묶여 있었고 얼굴에는 폭행당한 흔적이 있었다. 집 안에서는 번개탄을 피운 흔적이 발견됐다.","2023-08-30 12:00"))
        newsList.add(NewsItem(R.drawable.news3,"野위성곤 \"도쿄전력의 입\"…한총리 \"예의없다, 국민 위해 얘기\"", "" +
                "(서울=연합뉴스) " +
                "이동환 기자 = 한덕수 국무총리와 더불어민주당 위성곤 의원이 30일 후쿠시마 제1원자력발전소 오염수 방류에 대한 정부 대응을 놓고 설전을 벌였다.\n" +
                "\n" +
                "위 의원은 이날 오전 국회 예산결산특별위원회 종합정책질의에서 \"바나나에는 삼중수소가 없다\"며 \"정부는 바나나에도 삼중수소가 있는 것처럼 유튜브와 문서로 국민들을 현혹하고 있다\"고 비판했다.\n" +
                "\n" +
                "그러면서 \"지금 우리 정부는 도쿄전력의 입이 돼버렸다\"고 주장했다.\n" +
                "\n" +
                "그러자 한 총리는 \"어떻게 정부가 이야기하는데 도쿄전력의 입이라고 이야기를 합니까\"라며 \"예의가 없으신거에요\"라고 목소리를 높였다.","2023-08-30 13:52"))
        newsList.add(NewsItem(R.drawable.new4,"국정기획수석 \"채상병 軍 수사 결과 尹대통령에 보고 안돼\"", "(서울=연합뉴스) " +
                "이동환 " +
                "기자" +
                " = 이관섭 대통령실 국정기획수석은 30일 해병대 채 모 상병 순직 사건에 대한 군 수사 결과와 관련, \"(윤석열 대통령에게) 보고되지 않은 것으로 알고 있다\"고 밝혔다.\n" +
                "\n" +
                "이 수석은 이날 오후 국회 예산결산특별위원회 종합정책질의에서 지난달 31일 대통령 주재 수석비서관 회의에서 해당 수사 결과가 윤 대통령에게 보고됐느냐는 더불어민주당 진성준 의원의 질의에 이같이 답했다.\n" +
                "\n" +
                "앞서 박정훈 전 해병대 수사단장(대령)은 지난 28일 국방부 검찰단에 출석해 국방부가 채상병 순직 사건의 경찰 이첩을 보류시킨 배경에 윤 대통령" +
                " 의중이 있었다는 취지의 진술서를 제출했다.","2023-08-30 13:34"))
        newsList.add(NewsItem(R.drawable.news5,"국정기획수석 \"채상병 軍 수사 결과 尹대통령에 보고 안돼\"","(서울=연합뉴스) 이동환 " +
                "기자" +
                " = 이관섭 대통령실 국정기획수석은 30일 해병대 채 모 상병 순직 사건에 대한 군 수사 결과와 관련, \"(윤석열 대통령에게) 보고되지 않은 것으로 알고 있다\"고 밝혔다.\n" +
                "\n" +
                "이 수석은 이날 오후 국회 예산결산특별위원회 종합정책질의에서 지난달 31일 대통령 주재 수석비서관 회의에서 해당 수사 결과가 윤 대통령에게 보고됐느냐는 더불어민주당 진성준 의원의 질의에 이같이 답했다.\n" +
                "\n" +
                "앞서 박정훈 전 해병대 수사단장(대령)은 지난 28일 국방부 검찰단에 출석해 국방부가 채상병 순직 사건의 경찰 이첩을 보류시킨 배경에 윤 대통령 의중이 있었다는 취지의 진술서를 제출했다.","2023-08-30 15:37"))
        newsList.add(NewsItem(R.drawable.news6,"여권, '오염수' 명칭 변경 검토…\"오염 처리수가 맞아\"(종합2보)","(서울·광주=연합뉴스) 최평천 안채원 곽민서 기자 = 여권이 30일 일본 후쿠시마 원전 오염수 명칭 변경을 검토해야 한다는 입장을 밝혔다.\n" +
                "\n" +
                "김기현 대표는 이날 경기도 광주에서 열린 경기도의회 국민의힘 현장정책회의를 마치고 기자들과 만나 오염수 명칭을 변경해야 한다는 주장과 관련, \"실제로 배출되는 것이 오염수를 처리한 후 나오는 것이기 때문에 '그런 의미를 반영하는 것이 좋지 않겠느냐'는 의견인 것 같다\"고 말했다.\n" +
                "\n" +
                "유상범 수석대변인도 취재진에게 \"IAEA(국제원자력기구)가 공식적으로 사용하는 용어가 오염 처리수이기 때문에 그 용어를 쓸지를 검토해봐야 " +
                "한다고 생각한다\"고 밝혔다. 다만 \"당 차원에서 오염 처리수로 할지는 공식적으로 결정된 바 없다\"고 말했다.","2023-08-30 18:10"))
        newsList.add(NewsItem(R.drawable.news7,"군검찰, '항명' 혐의 박정훈 전 해병대 수사단장 구속영장 청구(종합)","(서울=연합뉴스) 김승욱 박수윤 기자 = 국방부 검찰단이 채 모 상병 순직 사건을 수사하다 항명 혐의로 입건된 박정훈(대령) 전 해병대 수사단장에 대해 30일 사전 구속영장을 청구했다.\n" +
                "\n" +
                "국방부는 \"그동안 검찰단은 피의자에 대한 신속한 수사를 위해 노력했으나, 피의자가 계속 수사를 거부하고 있는 상황에서 사안의 중대성 및 증거인멸 우려를 고려해 구속영장을 청구했다\"고 밝혔다.\n" +
                "\n" +
                "이어 \"잇따른 피의자의 일방적 주장 발표에 유감을 표하며, 피의자가 수사절차 내에서 관련 증거에 대한 의견을 밝히는 등 필요한 주장을 하기를 기대한다\"고 덧붙였다.","2023-08-30 18:35"))
        newsList.add(NewsItem(R.drawable.news8,"작년 출생아수 25만명 아래로…합계출산율 0.7명대로 내려앉아","(세종=연합뉴스) 박원희 기자 = 지난해 출생아 수가 사상 처음 25만명을 밑돌며 역대 가장 적었다.\n" +
                "\n" +
                "여성 1명이 평생 낳을 것으로 예상되는 평균 출생아 수인 합계출산율도 0.7명대로 떨어지며 사상 최저를 기록했다.\n" +
                "\n" +
                "모든 시군구가 현재 인구 규모를 유지하는 데 필요한 합계출산율을 밑도는 가운데 서울 관악구가 가장 낮은 출산율을 기록했다.","2023-08-30 12:00"))

        val adapter = TitleFragmentAdapter(newsList)
        binding.titleRecyclerView.adapter = adapter
        binding.titleRecyclerView.layoutManager = LinearLayoutManager(requireContext())

        val divider = DividerItemDecoration(requireContext(),LinearLayoutManager.VERTICAL)
        binding.titleRecyclerView.addItemDecoration(divider)

        val itemList = arrayListOf<NewsItem>()
        adapter.newsClick = object : TitleFragmentAdapter.Click{
            override fun onClick(view: View, position: Int) {
                val item = newsList[position]
                itemList.add(item)
                val bundle = Bundle()
                bundle.putParcelableArrayList("titleitem", itemList)
                Log.d("TitleFragment",itemList.toString())
                setFragmentResult("titlekey",bundle)
                (activity as MainActivity).tabLayout.getTabAt(1)?.select()
            }
        }

        return view
    }
}